/*
* Classname:    WSFileUpload.java
* Author:       Héctor Hernández Chávez
* Date:         12-ago-2019
*/
package javaee.examples.ejb.async.reactive;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Héctor Hernández Chávez
 */
@Path("async/upload")
public class WSFileUpload {

    @Inject
    private PdfHandler pdfHandler;
    
    @Inject
    private JpgHandler jpgHandler;
    
    @Inject
    private ZipHandler zipHandler;
    
    @Inject
    private BeanManager beanManager;
    
    @Resource
    private ManagedExecutorService executor;
    
    @POST
    @Path("pdf")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadPdf(File file) throws IOException {
        FileBean fileBean = new FileBean(file, "pdf");
        pdfHandler.handler(fileBean);
        return Response.ok().build();
    }
    
    @POST
    @Path("jpg")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadJpg(File file) throws IOException {
        FileBean fileBean = new FileBean(file, "jpg");
        jpgHandler.handler(fileBean);
        return Response.ok().build();
    }
    
    @POST
    @Path("zip")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadZip(File file) throws IOException {
        FileBean fileBean = new FileBean(file, "zip");
        zipHandler.handler(fileBean);
        return Response.ok().build();
    }
    
    @POST
    @Path("pdf/cs")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public CompletionStage<String> uploadPdfCs(File file) {
        CompletableFuture<String> completionStage = new CompletableFuture<>();
        executor.execute(() -> {
            FileBean fileBean = new FileBean(file, "pdf");
            Bean<PdfHandler> bean = (Bean) beanManager.getBeans(PdfHandler.class).iterator().next();
            CreationalContext cCtx = beanManager.createCreationalContext(bean);
            PdfHandler ph = (PdfHandler) beanManager.getReference(bean, PdfHandler.class, cCtx);
            try {
                completionStage.complete(ph.handlerCs(fileBean));
            } catch (IOException ioe) {
                ioe.printStackTrace();
                completionStage.completeExceptionally(ioe);
            }
        });
        return completionStage;
    }
    
    @POST
    @Path("jpg/cs")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public CompletionStage<String> uploadJpgCs(File file) {
        CompletableFuture<String> completionStage = new CompletableFuture<>();
        executor.execute(() -> {
            FileBean fileBean = new FileBean(file, "jpg");
            Bean<JpgHandler> bean = (Bean) beanManager.getBeans(JpgHandler.class).iterator().next();
            CreationalContext cCtx = beanManager.createCreationalContext(bean);
            JpgHandler jh = (JpgHandler) beanManager.getReference(bean, JpgHandler.class, cCtx);
            try {
                completionStage.complete(jh.handlerCs(fileBean));
            } catch (IOException ioe) {
                ioe.printStackTrace();
                completionStage.completeExceptionally(ioe);
            }
        });
        return completionStage;
    }
    
    @POST
    @Path("zip/cs")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public CompletionStage<String> uploadZipCs(File file) {
        CompletableFuture<String> completionStage = new CompletableFuture<>();
        executor.execute(() -> {
            FileBean fileBean = new FileBean(file, "zip");
            Bean<ZipHandler> bean = (Bean) beanManager.getBeans(ZipHandler.class).iterator().next();
            CreationalContext cCtx = beanManager.createCreationalContext(bean);
            ZipHandler zh = (ZipHandler) beanManager.getReference(bean, ZipHandler.class, cCtx);
            try {
                completionStage.complete(zh.handlerCs(fileBean));
            } catch (IOException ioe) {
                ioe.printStackTrace();
                completionStage.completeExceptionally(ioe);
            }
        });
        return completionStage;
    }
}

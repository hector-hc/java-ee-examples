/*
* Classname:    WSFileUpload.java
* Author:       Héctor Hernández Chávez
* Date:         12-ago-2019
*/
package javaee.examples.cdi.events.reactive.ws;

import java.io.File;
import java.util.Objects;
import javaee.examples.cdi.events.reactive.FileEvent;
import javaee.examples.cdi.events.reactive.Jpg;
import javaee.examples.cdi.events.reactive.Pdf;
import javaee.examples.cdi.events.reactive.Zip;
import javax.enterprise.event.Event;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Héctor Hernández Chávez
 */
@Path("events/reactive/upload")
public class WSFileUpload {

    @Inject
    Event<FileEvent> fileEvent;
    
    @POST
    @Path("pdf")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response updloadPdf(File file) {
        FileEvent fe = new FileEvent(file, "pdf");
        Event<FileEvent> pdfEvent = this.fileEvent.select(new AnnotationLiteral<Pdf>() {});
        pdfEvent.fireAsync(fe).whenComplete((event, err) -> {
            if (Objects.isNull(err)) {
                System.out.println("PDF saved");
            } else {
                err.printStackTrace();
            }
        });
        return Response.ok().build();
    }
    
    @POST
    @Path("jpg")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response updloadJpg(File file) {
        FileEvent fe = new FileEvent(file, "jpg");
        Event<FileEvent> pdfEvent = this.fileEvent.select(new AnnotationLiteral<Jpg>() {});
        pdfEvent.fireAsync(fe).whenComplete((event, err) -> {
            if (Objects.isNull(err)) {
                System.out.println("JPG saved");
            } else {
                err.printStackTrace();
            }
        });
        return Response.ok().build();
    }
    
    @POST
    @Path("zip")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response updloadZip(File file) {
        FileEvent fe = new FileEvent(file, "zip");
        Event<FileEvent> pdfEvent = this.fileEvent.select(new AnnotationLiteral<Zip>() {});
        pdfEvent.fireAsync(fe).whenComplete((event, err) -> {
            if (Objects.isNull(err)) {
                System.out.println("ZIP saved");
            } else {
                err.printStackTrace();
            }
        });
        return Response.ok().build();
    }
}

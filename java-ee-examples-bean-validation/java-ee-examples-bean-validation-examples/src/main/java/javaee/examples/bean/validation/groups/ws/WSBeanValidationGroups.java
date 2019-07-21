/**
 * @Class WSBeanValidationGroups
 * @author Hector
 * @Created on Jul 21, 2019, 3:11:40 PM
 */
package javaee.examples.bean.validation.groups.ws;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;
import javaee.examples.bean.validation.groups.BuilderOrder;
import javaee.examples.bean.validation.groups.Creation;
import javaee.examples.bean.validation.groups.Delivery;
import javaee.examples.bean.validation.groups.Order;
import javaee.examples.bean.validation.groups.OrderLine;
import javaee.examples.bean.validation.groups.Payment;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;

@Path("groups")
public class WSBeanValidationGroups {

    @Inject
    Logger logger;

    @Inject
    ValidatorFactory validatorFactory;
    @Inject
    Validator validator;

    @Inject
    BuilderOrder builderOrder;

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getOrder() {
        Order order = new Order();
        order.setId(1L);
        order.setCreationDate(LocalDate.now().minusDays(5));
        order.setTotalAmount(100d);
        order.setPaymentDate(LocalDate.now().minusDays(4));
        order.setDeliveryDate(LocalDate.now().minusDays(3));
        OrderLine orderLine = new OrderLine();
        orderLine.setItem("AA01");
        orderLine.setQuantity(1);
        orderLine.setUnitPrice(100d);
        order.addOrderLine(orderLine);
        return Response.ok(order).build();
    }

    @POST
    @Path("creation")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response creationOrder(final Order order) {
        logger.info("order_creation: {}/{}", order, validator);
        Set<ConstraintViolation<Order>> constraints = validator.validate(order, Creation.class);
        if (constraints.size() > 0) {
            String msg = constraints.stream().map(c -> c.getMessage()).collect(Collectors.joining(","));
            return Response.status(Response.Status.BAD_REQUEST).entity(msg).build();
        }
        return Response.ok().build();
    }

    @POST
    @Path("creation/cdi")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response creationOrderCdi(final Order order) {
        logger.info("order_creation: {}", order);
        builderOrder.builderOrderCreation(order);
        return Response.ok().build();
    }

    @POST
    @Path("payment")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response paymentOrder(final Order order) {
        logger.info("order_payment: {}/{}", order, validator);
        Set<ConstraintViolation<Order>> constraints = validator.validate(order, Payment.class);
        if (constraints.size() > 0) {
            String msg = constraints.stream().map(c -> c.getMessage()).collect(Collectors.joining(","));
            return Response.status(Response.Status.BAD_REQUEST).entity(msg).build();
        }
        return Response.ok().build();
    }

    @POST
    @Path("payment/cdi")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response paymentOrderCdi(final Order order) {
        builderOrder.builderOrderPayment(order);
        return Response.ok().build();
    }

    @POST
    @Path("delivery")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response deliveryOrder(final Order order) {
        logger.info("order_delivery: {}/{}", order, validator);
        Set<ConstraintViolation<Order>> constraints = validator.validate(order, Delivery.class);
        if (constraints.size() > 0) {
            String msg = constraints.stream().map(c -> c.getMessage()).collect(Collectors.joining(","));
            return Response.status(Response.Status.BAD_REQUEST).entity(msg).build();
        }
        return Response.ok().build();
    }

    @POST
    @Path("delivery/cdi")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response deliveryOrderCdi(final Order order) {
        logger.info("order_delivery: {}", order);
        builderOrder.builderOrderDelivery(order);
        return Response.ok().build();
    }
}

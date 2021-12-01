package example.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.38.0)",
    comments = "Source: FieldMask.proto")
public final class UserinfoServiceGrpc {

  private UserinfoServiceGrpc() {}

  public static final String SERVICE_NAME = "fieldmask.UserinfoService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<example.grpc.UserIdx,
      example.grpc.Userinfo> getGetUserinfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUserinfo",
      requestType = example.grpc.UserIdx.class,
      responseType = example.grpc.Userinfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<example.grpc.UserIdx,
      example.grpc.Userinfo> getGetUserinfoMethod() {
    io.grpc.MethodDescriptor<example.grpc.UserIdx, example.grpc.Userinfo> getGetUserinfoMethod;
    if ((getGetUserinfoMethod = UserinfoServiceGrpc.getGetUserinfoMethod) == null) {
      synchronized (UserinfoServiceGrpc.class) {
        if ((getGetUserinfoMethod = UserinfoServiceGrpc.getGetUserinfoMethod) == null) {
          UserinfoServiceGrpc.getGetUserinfoMethod = getGetUserinfoMethod =
              io.grpc.MethodDescriptor.<example.grpc.UserIdx, example.grpc.Userinfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetUserinfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  example.grpc.UserIdx.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  example.grpc.Userinfo.getDefaultInstance()))
              .setSchemaDescriptor(new UserinfoServiceMethodDescriptorSupplier("GetUserinfo"))
              .build();
        }
      }
    }
    return getGetUserinfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<example.grpc.Userinfo,
      example.grpc.UserIdx> getPutUserinfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PutUserinfo",
      requestType = example.grpc.Userinfo.class,
      responseType = example.grpc.UserIdx.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<example.grpc.Userinfo,
      example.grpc.UserIdx> getPutUserinfoMethod() {
    io.grpc.MethodDescriptor<example.grpc.Userinfo, example.grpc.UserIdx> getPutUserinfoMethod;
    if ((getPutUserinfoMethod = UserinfoServiceGrpc.getPutUserinfoMethod) == null) {
      synchronized (UserinfoServiceGrpc.class) {
        if ((getPutUserinfoMethod = UserinfoServiceGrpc.getPutUserinfoMethod) == null) {
          UserinfoServiceGrpc.getPutUserinfoMethod = getPutUserinfoMethod =
              io.grpc.MethodDescriptor.<example.grpc.Userinfo, example.grpc.UserIdx>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PutUserinfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  example.grpc.Userinfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  example.grpc.UserIdx.getDefaultInstance()))
              .setSchemaDescriptor(new UserinfoServiceMethodDescriptorSupplier("PutUserinfo"))
              .build();
        }
      }
    }
    return getPutUserinfoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserinfoServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserinfoServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserinfoServiceStub>() {
        @java.lang.Override
        public UserinfoServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserinfoServiceStub(channel, callOptions);
        }
      };
    return UserinfoServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserinfoServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserinfoServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserinfoServiceBlockingStub>() {
        @java.lang.Override
        public UserinfoServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserinfoServiceBlockingStub(channel, callOptions);
        }
      };
    return UserinfoServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserinfoServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserinfoServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserinfoServiceFutureStub>() {
        @java.lang.Override
        public UserinfoServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserinfoServiceFutureStub(channel, callOptions);
        }
      };
    return UserinfoServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class UserinfoServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getUserinfo(example.grpc.UserIdx request,
        io.grpc.stub.StreamObserver<example.grpc.Userinfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetUserinfoMethod(), responseObserver);
    }

    /**
     */
    public void putUserinfo(example.grpc.Userinfo request,
        io.grpc.stub.StreamObserver<example.grpc.UserIdx> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPutUserinfoMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetUserinfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                example.grpc.UserIdx,
                example.grpc.Userinfo>(
                  this, METHODID_GET_USERINFO)))
          .addMethod(
            getPutUserinfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                example.grpc.Userinfo,
                example.grpc.UserIdx>(
                  this, METHODID_PUT_USERINFO)))
          .build();
    }
  }

  /**
   */
  public static final class UserinfoServiceStub extends io.grpc.stub.AbstractAsyncStub<UserinfoServiceStub> {
    private UserinfoServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserinfoServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserinfoServiceStub(channel, callOptions);
    }

    /**
     */
    public void getUserinfo(example.grpc.UserIdx request,
        io.grpc.stub.StreamObserver<example.grpc.Userinfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUserinfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void putUserinfo(example.grpc.Userinfo request,
        io.grpc.stub.StreamObserver<example.grpc.UserIdx> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPutUserinfoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UserinfoServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<UserinfoServiceBlockingStub> {
    private UserinfoServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserinfoServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserinfoServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public example.grpc.Userinfo getUserinfo(example.grpc.UserIdx request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUserinfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public example.grpc.UserIdx putUserinfo(example.grpc.Userinfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPutUserinfoMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UserinfoServiceFutureStub extends io.grpc.stub.AbstractFutureStub<UserinfoServiceFutureStub> {
    private UserinfoServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserinfoServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserinfoServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<example.grpc.Userinfo> getUserinfo(
        example.grpc.UserIdx request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUserinfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<example.grpc.UserIdx> putUserinfo(
        example.grpc.Userinfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPutUserinfoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_USERINFO = 0;
  private static final int METHODID_PUT_USERINFO = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserinfoServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserinfoServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_USERINFO:
          serviceImpl.getUserinfo((example.grpc.UserIdx) request,
              (io.grpc.stub.StreamObserver<example.grpc.Userinfo>) responseObserver);
          break;
        case METHODID_PUT_USERINFO:
          serviceImpl.putUserinfo((example.grpc.Userinfo) request,
              (io.grpc.stub.StreamObserver<example.grpc.UserIdx>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class UserinfoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserinfoServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return example.grpc.UserProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserinfoService");
    }
  }

  private static final class UserinfoServiceFileDescriptorSupplier
      extends UserinfoServiceBaseDescriptorSupplier {
    UserinfoServiceFileDescriptorSupplier() {}
  }

  private static final class UserinfoServiceMethodDescriptorSupplier
      extends UserinfoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UserinfoServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (UserinfoServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserinfoServiceFileDescriptorSupplier())
              .addMethod(getGetUserinfoMethod())
              .addMethod(getPutUserinfoMethod())
              .build();
        }
      }
    }
    return result;
  }
}

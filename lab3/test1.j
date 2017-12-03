.class public test1
.super java/lang/Object

.method public <init>()V
  .limit locals 1
  .limit stack  1

  aload_0
  invokespecial java/lang/Object/<init>()V
  return

.end method

.method public static main([Ljava/lang/String;)V
  .limit locals 1
  .limit stack  1

  invokestatic test1/main()I
  pop
  return

.end method


.method public static main()I
  .limit locals 1
  .limit stack 1

  iconst_2
  istore_0
  iload_0
  invokestatic test1/foo(I)I
  invokestatic Runtime/printInt(I)V
  iload_0
  ireturn

.end method

.method public static foo(I)I
  .limit locals 1
  .limit stack 2

  iload_0
  iconst_1
  isub
  istore_0
  iload_0
  ireturn

.end method

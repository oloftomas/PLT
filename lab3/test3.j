.class public test3
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

  invokestatic test3/main()I
  pop
  return

.end method


.method public static main()I
  .limit locals 2
  .limit stack 2

  iconst_0
  istore_0
  iconst_1
  iconst_2
  if_icmplt   L0
  istore_1
  L0:
  iconst_0
  if_icmpeq L1
  iconst_0
  ireturn

.end method

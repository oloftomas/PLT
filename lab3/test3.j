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
  .limit stack 3

  iconst_0
  istore_0
  bipush 10
  istore_1
  L0:
  iconst_1
  iload_1
  iload_0
  if_icmpne L2
  pop
  iconst_0
  L2:
  ifeq L1
  iload_1
  dup
  iconst_1
  isub
  istore_1
  invokestatic Runtime/printInt(I)V
  goto L0
  L1:
  iconst_0
  ireturn

.end method

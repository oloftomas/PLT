.class public test4
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

  invokestatic test4/main()I
  pop
  return

.end method


.method public static main()I
  .limit locals 2
  .limit stack 3

  iconst_1
  istore_0
  iconst_0
  istore_1
  iconst_1
  iload_0
  iload_1
  if_icmpeq L2
  pop
  iconst_0
  L2:
  ifeq L1
  bipush 10
  invokestatic Runtime/printInt(I)V
  goto L0
  L1:
  bipush 15
  invokestatic Runtime/printInt(I)V
  L0:
  iconst_0
  ireturn

.end method

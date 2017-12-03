.class public test2
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

  invokestatic test2/main()I
  pop
  return

.end method


.method public static main()I
  .limit locals 2
  .limit stack 2

  bipush 20
  istore_0
  iconst_4
  istore_1
  iload_0
  iload_1
  iadd
  invokestatic Runtime/printInt(I)V
  iconst_0
  ireturn

.end method

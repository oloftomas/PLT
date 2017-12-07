.class public core103
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

  invokestatic core103/main()I
  pop
  return

.end method


.method public static main()I
  .limit locals 2
  .limit stack 3

  iconst_4
  istore_0
  L0:
  iconst_1
  iload_0
  bipush 6
  if_icmplt L2
  pop
  iconst_0
  L2:
  ifeq L1
  iconst_0
  istore_1
  iload_1
  dup
  iconst_1
  iadd
  istore_1
  pop
  iload_1
  invokestatic Runtime/printInt(I)V
  iload_0
  dup
  iconst_1
  iadd
  istore_0
  pop
  goto L0
  L1:
  iconst_1
  iload_0
  bipush 7
  if_icmplt L5
  pop
  iconst_0
  L5:
  ifeq L4
  iload_0
  dup
  iconst_1
  iadd
  istore_0
  pop
  goto L3
  L4:
  iload_0
  dup
  iconst_1
  isub
  istore_0
  pop
  L3:
  iload_0
  invokestatic Runtime/printInt(I)V
  iload_0
  ireturn

.end method

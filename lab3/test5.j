.class public test5
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

  invokestatic test5/main()I
  pop
  return

.end method


.method public static main()I
  .limit locals 1
  .limit stack 5

  iconst_4
  istore_0
  iconst_0
  iconst_0
  iconst_1
  iconst_3
  iload_0
  if_icmple L4
  pop
  iconst_0
  L4:
  ifeq L3
  iconst_1
  iconst_4
  iconst_2
  if_icmpne L5
  pop
  iconst_0
  L5:
  ifeq L3
  pop
  iconst_1
  L3:
  ifeq L2
  iconst_1
  ifeq L2
  pop
  iconst_1
  L2:
  ifeq L1
  iconst_1
  invokestatic test5/printBool(Z)V
  goto L0
  L1:
  L0:
  iconst_1
  iconst_1
  iconst_1
  invokestatic test5/eq_bool(ZZ)Z
  ifne L6
  iconst_1
  invokestatic test5/dontCallMe(I)Z
  ifne L6
  pop
  iconst_0
  L6:
  invokestatic test5/printBool(Z)V
  iconst_0
  iconst_1
  iconst_4
  bipush 50
  if_icmpgt L8
  pop
  iconst_0
  L8:
  ifeq L7
  iconst_2
  invokestatic test5/dontCallMe(I)Z
  ifeq L7
  pop
  iconst_1
  L7:
  invokestatic test5/printBool(Z)V
  iconst_0
  iconst_0
  iconst_1
  iconst_4
  iload_0
  if_icmpeq L11
  pop
  iconst_0
  L11:
  ifeq L10
  iconst_1
  iconst_0
  invokestatic test5/eq_bool(ZZ)Z
  ifeq L10
  pop
  iconst_1
  L10:
  ifeq L9
  iconst_1
  ifeq L9
  pop
  iconst_1
  L9:
  invokestatic test5/printBool(Z)V
  iconst_0
  iconst_0
  invokestatic test5/implies(ZZ)Z
  invokestatic test5/printBool(Z)V
  iconst_0
  iconst_1
  invokestatic test5/implies(ZZ)Z
  invokestatic test5/printBool(Z)V
  iconst_1
  iconst_0
  invokestatic test5/implies(ZZ)Z
  invokestatic test5/printBool(Z)V
  iconst_1
  iconst_1
  invokestatic test5/implies(ZZ)Z
  invokestatic test5/printBool(Z)V
  iconst_0
  ireturn

.end method

.method public static dontCallMe(I)Z
  .limit locals 1
  .limit stack 1

  iload_0
  invokestatic Runtime/printInt(I)V
  iconst_1
  ireturn

.end method

.method public static printBool(Z)V
  .limit locals 1
  .limit stack 1

  iload_0
  ifeq L13
  iconst_1
  invokestatic Runtime/printInt(I)V
  goto L12
  L13:
  iconst_0
  invokestatic Runtime/printInt(I)V
  L12:
  return

.end method

.method public static implies(ZZ)Z
  .limit locals 2
  .limit stack 3

  iconst_1
  iload_0
  invokestatic test5/not(Z)Z
  ifne L14
  iload_0
  iload_1
  invokestatic test5/eq_bool(ZZ)Z
  ifne L14
  pop
  iconst_0
  L14:
  ireturn

.end method

.method public static not(Z)Z
  .limit locals 2
  .limit stack 1

  iload_0
  ifeq L16
  iconst_0
  istore_1
  iload_1
  pop
  goto L15
  L16:
  iconst_1
  istore_1
  iload_1
  pop
  L15:
  iload_1
  ireturn

.end method

.method public static eq_bool(ZZ)Z
  .limit locals 3
  .limit stack 1

  iload_0
  ifeq L18
  iload_1
  istore_2
  iload_2
  pop
  goto L17
  L18:
  iload_1
  invokestatic test5/not(Z)Z
  istore_2
  iload_2
  pop
  L17:
  iload_2
  ireturn

.end method

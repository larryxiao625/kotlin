// FIR_IDENTICAL
// This test can be removed as soon as the compiler stops supporting language version 1.5.
// !LANGUAGE: -ProhibitJvmFieldOnOverrideFromInterfaceInPrimaryConstructor
// SKIP_KT_DUMP
// SKIP_KLIB_TEST
// WITH_STDLIB

interface A { val x: Int }

class B(@JvmField override val x: Int): A

class C<D: A>(@JvmField val d: D)

class E(c: C<B>) { val ax = c.d.x }

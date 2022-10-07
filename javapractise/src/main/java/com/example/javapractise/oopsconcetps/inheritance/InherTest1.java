package com.example.javapractise.oopsconcetps.inheritance;

public class InherTest1 {
	public static void main(String[] args) {
		ChildClassSimple cl = new ChildClassSimple();
		// cl.display();
		// System.out.println(cl.var1);
		// System.out.println(cl.var2);
//************************************************************************
		System.out.println("************************************************************************");
		ChildClassInstanceVarCheck ch = new ChildClassInstanceVarCheck();
		BaseClassInstanceVarCheck bs = new ChildClassInstanceVarCheck();
		BaseClassInstanceVarCheck bs2 = new BaseClassInstanceVarCheck();

		// System.out.println(ch.a);
		// System.out.println(bs.a);
		// System.out.println(bs2.a);
// ************************************************************************
		System.out.println("************************************************************************");
		OverridingMethodChild oc = new OverridingMethodChild();
		// oc.show();

		OverridingMethodParent op = new OverridingMethodChild();
		// op.show();
// ************************************************************************
		System.out.println("************************************************************************");

		OverloadParentClass opc = new OverloadChildChildClass();
		OverloadChildClass occ = new OverloadChildChildClass();

		/*
		 * opc.display(); occ.display(); occ.display(52); opc.display("This");
		 * occ.display("YES", "NO");
		 */
		
		System.out.println("************************************************************************");
		
		HasARelationship2 ha2= new HasARelationship2();
		ha2.display();

	}
}

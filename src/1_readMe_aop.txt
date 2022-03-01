Spring AOP(Aspect Oriented Programming)

Business Problem:-
1. Same code(e.g. logging code, security code) to be executed at start of many methods, spread across layers.
2. Code Tangling, logging code popped in at every required method.
3. Code Scattering, if update or change in logging or security code, then update all classes.

Solution(I may think):- 
1. Inheritance,  Every class would extend a new class, plus no multiple inheritance.
2. Delegation, delegate logging, security calls, still update to every class is required.
If new feature like auditing, API management, instrumentation is required, more code change.

Solution(This will actually help):-
1. Programming Technique based on the concept of Aspect(Encapsulates cross-cutting logic)
CROSS CUTTING CONCERNS(logic)
2. Reused at multiple location, applied based on configuration.

Implementation of AOP Solution(Proxy Design Pattern):-
Main App--> AOP Proxy --Logging Aspect--Security Aspect-->TargetObject

Advantages/Benefit of AOP:-
1. Code resuability, single place so easy to change.
2. Bifurcates business code from logging/other codes
3. Configurable, aspects. No need to change the application code.

Disadvantages:-
1. Too many aspects and app flow is hard to follow
2. Minor performance cost for aspect execution(run-time weaving)

AOP UseCases:- logging, security,Transactions, Audit, 
Exception Handling(Support to DevOps Team), API Management(Method calls, peak times, average load)


Aspect:-Module of code for a cross-cutting concern
Advice:-What action is taken and when it should be applied
JoinPoint:- When to apply code during program execution
PointCut:-A predicate expression for where advice should be applied

Read AdviceTypes.txt

Weaving:- Connecting aspects to target objects to create an advised object, 
Different types of weaving
1. Compile time, Runtime(slowest)

Another framework for the same:- AspectJ(Better and more powerful)
Spring AOP, lighweight version of AOP.


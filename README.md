# Patterns

Abstract Factory
Type:Creational

Provides an interface for creating families of related or dependent objects without specifying their 
concrete class

Builder
Type:Creational

Separate the construction of a complex object from its representing so that the same construction 
process can create different representations.

Factory Method
Type:Creational

Define an interface for creating an object, but let subclasses decide which class to instantiate. Lets a class defer 
instantiation to subclasses

Singleton
Type:Creational

Ensure a class only has one instance and provide a global point of access to it

Prototype
Type:Creational

Specify the kinds of objects to create using a prototypical instance, and  create new objects by copying this 
prototype.

Chain of Responsibility
Type:Behavioral

Avoid coupling the sender of a request to its receiver by giving more than one object 
a chance to handle the request. Chain the receiving objects and pass the request 
along the chain until an object handles it.

Command
Type: Behavioral

Encapsulate a request as an object,thereby letting you parameterize clients
with different requests, queue or log requests, and support undoable operations.

Mediator
Type: Behavioral

Define an object that encapsulates how a set of objects interact. Promotes loose
coupling by keeping objects from referring to each other explicitly and it lets you vary
their interactions independently.

Memento
Type: Behavioral

Without violating encapsulation, capture and externalize an object's internal state
so that the object can be restored to this state later.
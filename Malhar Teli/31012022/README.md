#STRUCTURAL PATTERNS

In this assignment, I will create POCs to represent some of the core structural patterns in Java that are used to simplify the design of large object structures. 

These patterns take advantage of the relationships that are formed between objects as one's code base continues to expand.

1. Oberservable

    The observable design pattern defines communication between two objects- one the observable, the other the observer. Observable Objects inform Observer of any changes in the Obeservable's state, allowing the Observer to react as needed.

    Example: Pub/Sub
    
2. Bridge
    
    The Bridge pattern allow two implementations or abstractions to communicate with each other, while still being produced and run independently of one another. 

    Example: Connectors to Databases

3. Proxy

    The Proxy Pattern is used when dealing with large objects, allowing users to create one instance of the object and reference that same instance elsewhere. This means that the object will only be instantiated when needed, and will be the only instance of that same object. It comes in three distinct forms: 

    - Remote 
    - Virtual
    - Protection

    Example: JDBC 

4. Factory

    Factory Methods are methods described in an interface or abstract class that do not contain any specific requirements. This allows subclasses that inherit their properties to override these methods and replace them with their own functionality.
    Also known as a virtual Constructor.

5. Singleton 

    The Singleton Pattern used to define a class that is instantiated once and then made globally available. There's two forms of this pattern, centered around the timing of the Singleton's instantiation: 
    - Early Instantiation- Singleton Object is instantiated on program load time
    - Lazy Instantiation- Single Object is instantiated only when required.
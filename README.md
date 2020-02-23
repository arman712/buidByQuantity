# buidByQuantity
ContainerAutoBuild

This is a container that initializes and stores in itself (by scanning the path specified by the user) all objects based
on the BuildByQuantity annotation and its quantity attribute (the default value is exactly 1).
The container provides the getByIndex method, using which you can get the necessary objects by class name and index

Note: descendant classes do not inherit the annotation property of the super class and will not be initialized in the container.

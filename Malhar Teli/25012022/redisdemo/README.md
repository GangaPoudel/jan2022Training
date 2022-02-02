#REDIS demo

This is a project that demonstrates CRUD operations on a theoretical Redis server. Currently, it is untested, but the fundamentals are slightly different than a MySQL structure. Redis is a NOSQL interface- this means that columns and rows are, by nature, amorphous. Instead of calling upon Columns by name, we called on Keys which have associated Documents. 

Documents are returned when these keys are given. 

Documents, which do not have a strict structural definition, can be composed of all sorts of data, meaning we as developers can make good use of key naming according to a mutually agreed upon structure.
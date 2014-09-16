## What's easy to do in Scala? What's not?
We found it very easy to perform operations on entire collections and then further operate on the resulting collection(s). Pattern matching was easy to understand and fun to implement recursively. 

We found it difficult to perform particular operations functionally. For example, in the exercise in which we grouped consecutive elements of a collection, we had a lot of trouble creating a generic recursive algorithm rather than performing the task iteratively. We think that this difficulty arose due to our lack of experience using the built-in functions in Scala. Much to Scala's credit, there is a ton of easy-to-use functionality included in the language, but it is hard to be aware of all of it.\


## What is/are your favorite language design choice(s) that the designers of Scala made? Why?
Scala's "functional first" approach is an awesome language design choice. The builtin Options type is a really cool way to get rid of null and all the higher level functions work well with it, making it easy to incorporate it in our programs. Factory objects were also quite useful. So basically the object keyword for making one off objects.


## What is/are your least favorite language design choice(s)? Why? And why do you think the designers made that / those choice(s)?

The types get overly complicated very quickly. We found ourselves getting stuck often trying to get the right type. There isn't easy conversions from tuple to list, for example, which made some of the higher level functions less useful for the exercises. Ben said it was due to the designers having a strong base in mathematics.

## What Scala features would you like to learn more about?

The general collections API. There is so much powerful built-in functionality that we'd like to have in our toolbox. We'd like to know more about how Scala inheritance works as well.


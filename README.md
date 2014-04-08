# testRxJava

Testing API from [Netflix/RxJava](https://github.com/Netflix/RxJava).

## Example 0

A simple example that doesn't leverage RxJava, which results a blocking API.
You may notice a long pause while the DAO "retrieves" all the data to be displayed.

## Example 1

A simple synchronous call with RxJava.

## Example 2

A simple asynchronous call with RxJava.

## Example 3

A simple error handling approach.

## Example 4

A more elegant error handling approach on subscriber's end.

## Example 5

A subscriber's ability to unsubscribe at anytime.

## Example 6

The power of `skip(..)` and `take(..)` to create "pagination-like" way to traverse `Observable`.

## Example 7

Multi-thread processing.

## Example 8

Controlling concurrent threads.

## Example 9

What happen when an error occurs during multi-thread processing?

## Example 10

Pushing error to the end during multi-thread processing.

## Example 11

Pairing items with `zip(..)`.


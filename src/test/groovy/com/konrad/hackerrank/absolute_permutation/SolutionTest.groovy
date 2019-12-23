package com.konrad.hackerrank.absolute_permutation

import spock.lang.Specification


class SolutionTest extends Specification {

    def "n=4, k=2"() {
        expect:
        Solution.absolutePermutation(4, 2) == [3, 4, 1, 2]
    }

    def "n=2, k=1"() {
        expect:
        Solution.absolutePermutation(2, 1) == [2, 1]
    }

    def "n=3, k=0"() {
        expect:
        Solution.absolutePermutation(3, 0) == [1, 2, 3]
    }

    def "n=3, k=2"() {
        expect:
        Solution.absolutePermutation(3, 2) == [-1]
    }

    def "n=5, k=1"() {
        expect:
        Solution.absolutePermutation(5, 1) == [-1]
    }

    def "n=4, k=1"() {
        expect:
        Solution.absolutePermutation(4, 1) == [2, 1, 4, 3]
    }

    def "n=8, k=2"() {
        expect:
        Solution.absolutePermutation(8, 2) == [3, 4, 1, 2, 7, 8, 5, 6]
    }
}

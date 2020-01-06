package com.konrad.hackerrank.equal

import spock.lang.Specification

class SolutionTest extends Specification {
    def "2 2 3 7" () {
        expect:
        Solution.equal([2, 2, 3, 7] as int[]) == 2
    }

    def "10 7 12" () {
        expect:
        Solution.equal([10, 7, 12] as int[]) == 3
    }

    def "single element" () {
        expect:
        Solution.equal([2] as int[]) == 0
    }

    def "same elements" () {
        expect:
        Solution.equal([2, 2, 2] as int[]) == 0
    }

    def "1 5 5" () {
        expect:
        Solution.equal([1, 5, 5] as int []) == 3
    }

}

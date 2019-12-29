package com.konrad.hackerrank.knightL_on_a_chessboard

import spock.lang.Specification

class SolutionTest extends Specification {
    def "n = 5"() {
        expect:
        Solution.knightlOnAChessboard(5) as List == [[4, 4, 2, 8],[4, 2, 4, 4], [2, 4, -1, -1], [8, 4, -1, 1]] as List
    }
}

class Solution(object):
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        spiral_list = []

        while matrix:
            spiral_list += matrix.pop(0) 
            matrix = [*zip(*matrix)][::-1]
        return spiral_list
        
              
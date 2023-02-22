solution = lambda nums : int(len(set(nums))) if len(nums) / 2 > len(set(nums)) else int(len(nums) / 2)

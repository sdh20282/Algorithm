solution = lambda n, arr1, arr2 : [bin(item1 | item2)[2:].zfill(n).replace('1', '#').replace('0', ' ') for item1, item2 in zip(arr1, arr2)]

#1
def biggie_size(arr):
    for i in range(len(arr)):
        if arr[i] > 0:
            arr[i] = "big"
    return arr
print( biggie_size([-1, 3, 5, -5]))

#2
def count_positives(arr):
    count = 0
    for i in range(len(arr)):
        if arr[i] > 0:
            count += 1
    arr[-1] = count
    return arr
print(count_positives([-1,1,1,1]))
print(count_positives([1,6,-4,-2,-7,-2]))

#3
def sum_total(arr):
    count = 0
    for i in range(len(arr)):
        count = count + arr[i]
    return count

#4
def average(arr):
    sum = 0
    for i in range(len(arr)):
        sum = sum + arr[i]
    return sum / len(arr)
print(sum_total([1,2,3,4]))

#5
def length(arr):
    return len(arr)
print(length([37,2,1,-9]))

#6
def minimum(arr):
    min = arr[0]
    if len(arr) == 0:
        return False
    for i in arr:
        if i < min:
            min = i
    return min
print(minimum([37,2,1,-9]))  
#7
def maximum(arr):
    max = arr[0]
    if len(arr) == 0:
        return False
    for i in arr:
        if i > max:
            max = i
    return max       
print(maximum([37,2,1,-9]))   

#8
def ultimate_analyze(arr):
    dict = {
        'sumtotal' : sum_total(arr),
        'avg' : average(arr),
        'min' : minimum(arr),
        'max' : maximum(arr),
        'len' : length(arr)
    }
    return dict
print(ultimate_analyze([37,2,1,-9]))  

#9
def reversed(arr):
    arr = arr[::-1]
    return arr
print(reversed([37,2,1,-9]))    
#1
def countdown(num):
    nums_list = []
    for val in range(num, -1, -1):
        nums_list.append(val)
    return nums_list
print(countdown(5))        

#2
def print_and_return(num_list):
    print(num_list[0])
    return num_list[1]
print(print_and_return([1,2]))

#3
def first_plus_length(num_list):
    return num_list[0] + len(num_list)
print(first_plus_length([1,2,3,4,5]))

#4
def values_greater_than_second(num_list):
    new_list = []
    second_val = num_list[1]
    for idx in range(len(num_list)):
        if num_list[idx] > second_val:
            new_list.append(num_list[idx])

    print(len(new_list))
    return new_list

print(values_greater_than_second([5,2,3,2,1,4]))            

    

#5
def lengthAndValue(size, value):
    new_list = []
    for i in range(size):
        new_list.append(value)
    return new_list
    
print(lengthAndValue(4,7))       
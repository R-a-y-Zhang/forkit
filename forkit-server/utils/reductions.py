def reduce(arr, fn, default = None):
    acc = default
    s = 0
    if not default:
        acc = arr[0]
        s = 1
    for i in range(s, len(arr)):
        acc += fn(acc, arr[i])
    return acc
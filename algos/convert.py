class CONV:
    def __self__(self):
        self.KMMI = 0
        self.MIKM = 1
        self.MF = 2
        self.MF = 3
        self.CI = 4
        self.IC = 5

def imperial_metric(v, conv): # (double, int) -> double
    if conv == CONV.KMMI:
        return v * 1.60934
    elif conv == CONV.MIKM:
        return v / 1.60934
    elif conv == CONV.MF:
        return v / 3.28084
    elif conv == CONV.FM:
        return v * 3.28084
    elif conv == CONV.CI:
        return v / 2.54
    elif conv == CONV.IC:
        return v * 2.54

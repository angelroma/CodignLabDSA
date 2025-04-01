function missingNumber(nums: number[]): number {
    const numsSet = new Set(nums);

    const n = numsSet.size;

    for (let i = 0; i < n+1; i++) {
        console.log(i)
        if(!numsSet.has(i)) return i;
    }

    return 0;
};



const nums = [0,1]

console.log("output:", missingNumber(nums))

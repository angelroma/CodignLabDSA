function findMaxLength(nums: number[]): number {
    const map = new Map<number, number>();
    map.set(0, -1); // sum 0 occurs at index -1 (base case)

    let maxLength = 0;
    let sum = 0;

    for (let i = 0; i < nums.length; i++) {
        sum += nums[i] === 0 ? -1 : 1;

        if (map.has(sum)) {
            maxLength = Math.max(maxLength, i - map.get(sum)!);
        } else {
            map.set(sum, i);
        }
    }

    return maxLength;
}

// Test cases
const testCases = [
    [0,1,1,1,1,1,0,0,0],
    [1, 0, 1, 0, 1, 0, 1]
];

// Run test cases
testCases.forEach((nums, index) => {
    console.log(`Test case ${index + 1}:`, nums);
    console.log('Result:', findMaxLength(nums));
    console.log('---');
}); 
function checkIfPangram(sentence: string): boolean {
    const sentenceSet = new Set(sentence)
    return sentenceSet.size === 26
};
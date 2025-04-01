function subarraySum(nums: number[], k: number): number {
    const counts = new Map<number, number>();
    counts.set(0, 1);

    let ans = 0;
    let curr = 0;

    console.log("Inicio:");
    console.log(`nums = [${nums}], k = ${k}`);
    console.log("----");

    for (let i = 0; i < nums.length; i++) {
        const num = nums[i];
        curr += num;

        const target = curr - k;
        const countFound = counts.get(target) || 0;
        ans += countFound;

        console.log("counts.get(target) || 0", counts.get(target) || 0)

        console.log(`Índice ${i}, num = ${num}`);
        console.log(`  Suma acumulada (curr): ${curr}`);
        console.log(`  Busco si existe prefixSum = curr - k = ${curr} - ${k} = ${target}`);
        console.log(`  Encontrado en counts: ${countFound}`);
        console.log(`  Total de subarreglos encontrados hasta ahora: ${ans}`);

        // Actualizamos el mapa con la suma actual
        counts.set(curr, (counts.get(curr) || 0) + 1);
        console.log(`  counts actualizado:`);
        console.log(`    ${[...counts.entries()].map(([key, val]) => key + ": " + val).join(", ")}`);
        console.log("----");
    }

    console.log(`Resultado final: ${ans}`);
    return ans;
}

// Ejecutamos el ejemplo
const nums = [1, 2, 1, 2, 1];
subarraySum(nums, 3);


从 wrk压测中看，在 —Xmx512m -Xms512m情况下 
ParallelGC 的平均吞吐量最低
CMSGC 的平均吞吐量最高
G1GC 的平均吞吐量居中
但是本地实验结果 没有发现明显的差距
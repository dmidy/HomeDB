SELECT 'OLDEST' AS TYPE, Name, Birthday
FROM worker
ORDER BY Birthday ASC LIMIT 1
UNION
SELECT 'YOUNGEST' AS TYPE, Name, Birthday
FROM worker
ORDER BY Birthday DESC LIMIT 1;
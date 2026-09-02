# 🗄️ 100+ Deep-Dive Tricky SQL Interview MCQs (Master Guide)

A comprehensive compilation of **105 advanced, tricky, and deep-dive Multiple Choice Questions** designed to test relational database internals, SQL query execution order, 3-valued NULL logic, window functions, complex joins, indexing/SARGability, transaction isolation levels, and performance tuning.

---

## 📑 Table of Contents
1. [Section 1: Query Execution Order, Syntax & 3-Valued NULL Logic (Q1 – Q18)](#section-1-query-execution-order-syntax--3-valued-null-logic)
2. [Section 2: Joins, Set Operations & Complex Relationships (Q19 – Q32)](#section-2-joins-set-operations--complex-relationships)
3. [Section 3: Window Functions & Analytical Queries (Q33 – Q48)](#section-3-window-functions--analytical-queries)
4. [Section 4: Subqueries, CTEs & Advanced Querying (Q49 – Q65)](#section-4-subqueries-ctes--advanced-querying)
5. [Section 5: Aggregation, Grouping & Multidimensional Analytics (Q66 – Q78)](#section-5-aggregation-grouping--multidimensional-analytics)
6. [Section 6: Indexing, SARGability & Query Optimization (Q79 – Q92)](#section-6-indexing-sargability--query-optimization)
7. [Section 7: Transactions, ACID, Locking & Normalization (Q93 – Q105)](#section-7-transactions-acid-locking--normalization)

---

## Section 1: Query Execution Order, Syntax & 3-Valued NULL Logic

### Q1. What is the logical query processing (execution) order in SQL?
- A) `SELECT` -> `FROM` -> `WHERE` -> `GROUP BY` -> `HAVING` -> `ORDER BY`
- B) `FROM` -> `ON` -> `JOIN` -> `WHERE` -> `GROUP BY` -> `HAVING` -> `SELECT` -> `DISTINCT` -> `ORDER BY` -> `LIMIT / OFFSET`
- C) `FROM` -> `WHERE` -> `SELECT` -> `GROUP BY` -> `ORDER BY`
- D) `SELECT` -> `DISTINCT` -> `FROM` -> `JOIN` -> `WHERE` -> `ORDER BY`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `FROM` -> `ON` -> `JOIN` -> `WHERE` -> `GROUP BY` -> `HAVING` -> `SELECT` -> `DISTINCT` -> `ORDER BY` -> `LIMIT / OFFSET`**
**Explanation:** While a query is written starting with `SELECT`, the database engine processes the data source first (`FROM`/`JOIN`), filters rows (`WHERE`), aggregates (`GROUP BY`), filters groups (`HAVING`), selects projected columns (`SELECT`), removes duplicates (`DISTINCT`), sorts (`ORDER BY`), and finally paginates (`LIMIT/OFFSET`). This is why you cannot use column aliases defined in `SELECT` inside the `WHERE` clause!
</details>

---

### Q2. What is the result of `SELECT NULL = NULL;` and `SELECT NULL != NULL;` in SQL?
- A) `TRUE` and `FALSE`
- B) `FALSE` and `TRUE`
- C) `UNKNOWN` (evaluates as `NULL` / false in boolean conditions) for BOTH
- D) Syntax Error

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **C) `UNKNOWN` (evaluates as `NULL` / false in boolean conditions) for BOTH**
**Explanation:** SQL uses **Three-Valued Logic** (`TRUE`, `FALSE`, `UNKNOWN`). `NULL` represents an unknown value. You cannot compare an unknown value with another unknown value using `=` or `!=`. The only valid comparison is `IS NULL` or `IS NOT NULL`.
</details>

---

### Q3. Why does the following `NOT IN` query return 0 rows?
```sql
SELECT * FROM Customers 
WHERE id NOT IN (SELECT customer_id FROM Orders);
-- Assume Orders table contains records where customer_id is: 1, 2, NULL
```
- A) Syntax error in `NOT IN`
- B) If the subquery contains even a single `NULL` value, `NOT IN` evaluates to `UNKNOWN` for all rows, returning an empty result set
- C) `NOT IN` is not supported with subqueries
- D) Orders table has no primary key

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) If the subquery contains even a single `NULL` value, `NOT IN` evaluates to `UNKNOWN` for all rows, returning an empty result set**
**Explanation:** `id NOT IN (1, 2, NULL)` expands logically to: `id != 1 AND id != 2 AND id != NULL`. Because `id != NULL` evaluates to `UNKNOWN`, `TRUE AND TRUE AND UNKNOWN` yields `UNKNOWN`, rejecting all rows. To fix this, use `NOT EXISTS` or filter `WHERE customer_id IS NOT NULL` in the subquery.
</details>

---

### Q4. What is the difference between `COUNT(*)`, `COUNT(1)`, and `COUNT(column_name)`?
- A) `COUNT(*)` and `COUNT(1)` count all rows including NULLs; `COUNT(column_name)` counts only rows where `column_name` is `NOT NULL`
- B) `COUNT(1)` is faster than `COUNT(*)` in all databases
- C) `COUNT(*)` ignores NULLs
- D) `COUNT(column_name)` includes NULL values

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) `COUNT(*)` and `COUNT(1)` count all rows including NULLs; `COUNT(column_name)` counts only rows where `column_name` is `NOT NULL`**
**Explanation:** `COUNT(*)` and `COUNT(1)` evaluate to the total number of rows in the table/group. `COUNT(column_name)` explicitly skips/ignores `NULL` values in that specific column.
</details>

---

### Q5. What will the following query output?
```sql
SELECT COUNT(*) FROM (
    SELECT 1 AS num WHERE NULL = NULL
    UNION ALL
    SELECT 2 AS num WHERE NULL IS NULL
) t;
```
- A) `0`
- B) `1`
- C) `2`
- D) Throws an exception

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `1`**
**Explanation:** `NULL = NULL` evaluates to `UNKNOWN` (falsy), so the first query produces 0 rows. `NULL IS NULL` evaluates to `TRUE`, so the second query produces 1 row (`num = 2`). Total row count is `1`.
</details>

---

### Q6. What does `COALESCE(val1, val2, val3, ...)` return?
- A) The average of all non-null values
- B) The FIRST non-null expression from the argument list
- C) Concatenates all non-null values
- D) Returns null if any argument is null

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) The FIRST non-null expression from the argument list**
**Explanation:** `COALESCE(a, b, c)` is an ANSI SQL standard function that evaluates arguments left-to-right and returns the first non-null value. If all arguments are `NULL`, it returns `NULL`.
</details>

---

### Q7. What is the difference between `COALESCE` and `IFNULL` (or `NVL` in Oracle)?
- A) `COALESCE` is ANSI SQL standard and accepts 2 or more arguments; `IFNULL` / `NVL` is dialect-specific and accepts exactly 2 arguments
- B) `IFNULL` is faster
- C) `COALESCE` only works with strings
- D) `NVL` can take 10 arguments

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) `COALESCE` is ANSI SQL standard and accepts 2 or more arguments; `IFNULL` / `NVL` is dialect-specific and accepts exactly 2 arguments**
**Explanation:** `COALESCE` is portable across PostgreSQL, MySQL, SQL Server, Oracle, and SQLite, supporting arbitrary numbers of fallback parameters.
</details>

---

### Q8. What is the result of `SELECT 'Hello ' + NULL` in SQL Server vs `SELECT 'Hello ' || NULL` in Oracle?
- A) Both return `'Hello '`
- B) SQL Server returns `NULL` (unless `CONCAT_NULL_YIELDS_NULL` is OFF); Oracle treats `NULL` string as empty string `''` and returns `'Hello '`
- C) Both throw runtime exceptions
- D) Both return `NULL`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) SQL Server returns `NULL` (unless `CONCAT_NULL_YIELDS_NULL` is OFF); Oracle treats `NULL` string as empty string `''` and returns `'Hello '`**
**Explanation:** In standard SQL and SQL Server, any expression combined with `NULL` yields `NULL`. In Oracle SQL, `NULL` string literals are treated as empty strings `''`, so `'Hello ' || NULL` returns `'Hello '`. Using standard `CONCAT('Hello ', NULL)` in modern SQL returns `'Hello '`.
</details>

---

### Q9. Can you use a column alias defined in `SELECT` inside the `WHERE` clause of the same query block?
```sql
SELECT salary * 12 AS annual_salary
FROM employees
WHERE annual_salary > 50000; -- is this valid?
```
- A) Yes, always valid
- B) No, because `WHERE` is executed before `SELECT` in logical query processing
- C) Yes, but only in PostgreSQL
- D) Only with numeric aliases

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) No, because `WHERE` is executed before `SELECT` in logical query processing**
**Explanation:** At the time the `WHERE` clause executes, the `SELECT` clause has not yet evaluated or assigned column aliases. To filter by calculated values, repeat the expression in `WHERE`, wrap in a CTE/Subquery, or use `HAVING` (in MySQL).
</details>

---

### Q10. Can you use a column alias defined in `SELECT` inside the `ORDER BY` clause?
```sql
SELECT salary * 12 AS annual_salary
FROM employees
ORDER BY annual_salary DESC;
```
- A) No, aliases are not allowed anywhere
- B) Yes, because `ORDER BY` is executed AFTER `SELECT` in logical query processing
- C) Only with integer column position numbers
- D) Only in Oracle

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Yes, because `ORDER BY` is executed AFTER `SELECT` in logical query processing**
**Explanation:** Since `ORDER BY` runs after `SELECT`, the column aliases have already been created and are fully accessible for sorting.
</details>

---

### Q11. What is the difference between `CHAR(10)` and `VARCHAR(10)`?
- A) `CHAR(10)` is fixed-length and right-pads strings with spaces to 10 characters; `VARCHAR(10)` is variable-length and stores only the actual characters plus length bytes
- B) `CHAR(10)` can only store ASCII; `VARCHAR(10)` stores Unicode
- C) `VARCHAR(10)` always uses more storage than `CHAR(10)`
- D) `CHAR(10)` is deprecated

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) `CHAR(10)` is fixed-length and right-pads strings with spaces to 10 characters; `VARCHAR(10)` is variable-length and stores only the actual characters plus length bytes**
**Explanation:** If `'abc'` is stored in `CHAR(10)`, it consumes 10 bytes (padded with 7 trailing spaces). In `VARCHAR(10)`, it consumes 3 bytes + 1 byte overhead.
</details>

---

### Q12. What does `SELECT 1 WHERE 1 = 1 AND (1 = 2 OR NULL);` return?
- A) `1`
- B) Returns 0 rows (Empty set)
- C) Syntax error
- D) `NULL`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Returns 0 rows (Empty set)**
**Explanation:**
1. `(1 = 2 OR NULL)` -> `FALSE OR UNKNOWN` = `UNKNOWN`.
2. `1 = 1 AND UNKNOWN` -> `TRUE AND UNKNOWN` = `UNKNOWN`.
3. The `WHERE` clause filters out any row whose condition does not evaluate strictly to `TRUE`.
</details>

---

### Q13. How does `ORDER BY column_name ASC` handle `NULL` values by default in standard SQL vs Oracle vs PostgreSQL?
- A) Always at the top
- B) In MySQL/SQL Server, `NULL`s are treated as the lowest possible values (placed FIRST in `ASC`); In Oracle/PostgreSQL, `NULL`s are treated as the highest possible values (placed LAST in `ASC`, unless overridden with `NULLS FIRST / LAST`)
- C) Discards rows with NULL
- D) Throws an exception

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) In MySQL/SQL Server, `NULL`s are treated as the lowest possible values (placed FIRST in `ASC`); In Oracle/PostgreSQL, `NULL`s are treated as the highest possible values (placed LAST in `ASC`, unless overridden with `NULLS FIRST / LAST`)**
**Explanation:** ANSI SQL supports the explicit `NULLS FIRST` and `NULLS LAST` syntax (e.g. `ORDER BY price ASC NULLS LAST`) to remove vendor discrepancies.
</details>

---

### Q14. What is the output of `SELECT AVG(val) FROM (VALUES (10), (20), (NULL)) AS t(val);`?
- A) `10`
- B) `15`
- C) `NULL`
- D) `30`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `15`**
**Explanation:** Aggregate functions (`AVG`, `SUM`, `MIN`, `MAX`) automatically ignore `NULL` values. The sum is `10 + 20 = 30`, and the count of non-null elements is `2`. Average = $30 / 2 = 15$.
</details>

---

### Q15. What is the danger of `BETWEEN` when filtering datetime values?
```sql
-- Searching for events on 2024-05-15
WHERE event_time BETWEEN '2024-05-15' AND '2024-05-16'
```
- A) `BETWEEN` is inclusive on both bounds (`>= '2024-05-15 00:00:00' AND <= '2024-05-16 00:00:00'`), unintentionally capturing events occurring exactly at midnight on May 16th
- B) `BETWEEN` fails on date types
- C) It is always exclusive
- D) `BETWEEN` is slower than `LIKE`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) `BETWEEN` is inclusive on both bounds (`>= '2024-05-15 00:00:00' AND <= '2024-05-16 00:00:00'`), unintentionally capturing events occurring exactly at midnight on May 16th**
**Explanation:** For precise datetime range filtering, always use half-open intervals: `WHERE event_time >= '2024-05-15' AND event_time < '2024-05-16'`.
</details>

---

### Q16. What does `SELECT CASE WHEN NULL THEN 'A' ELSE 'B' END;` return?
- A) `'A'`
- B) `'B'`
- C) `NULL`
- D) Syntax Error

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `'B'`**
**Explanation:** In a `CASE WHEN <condition>`, the `THEN` branch is taken ONLY if the condition evaluates strictly to `TRUE`. Since `NULL` is `UNKNOWN` (not `TRUE`), it falls through to the `ELSE` branch, returning `'B'`.
</details>

---

### Q17. What happens if no `ELSE` branch is specified in a `CASE` expression and no condition matches?
- A) Returns `NULL`
- B) Throws a runtime exception
- C) Returns empty string
- D) Returns `0`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Returns `NULL`**
**Explanation:** If no `ELSE` clause is specified in a `CASE` expression and none of the `WHEN` conditions evaluate to `TRUE`, the default return value is implicitly `NULL`.
</details>

---

### Q18. What is the difference between `DELETE FROM table;` and `TRUNCATE TABLE table;`?
- A) `DELETE` is a DML command that deletes rows one by one, logs each row deletion in the transaction log, and fires triggers; `TRUNCATE` is a DDL command that deallocates entire data pages, is much faster, resets auto-increment identities, and does not fire row triggers
- B) `TRUNCATE` cannot be rolled back in any database
- C) `DELETE` cannot have a `WHERE` clause
- D) Both are identical

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) `DELETE` is a DML command that deletes rows one by one, logs each row deletion in the transaction log, and fires triggers; `TRUNCATE` is a DDL command that deallocates entire data pages, is much faster, resets auto-increment identities, and does not fire row triggers**
**Explanation:** (Common myth debunked: `TRUNCATE` CAN be rolled back if executed inside an active transaction in SQL Server and PostgreSQL!).
</details>

---

## Section 2: Joins, Set Operations & Complex Relationships

### Q19. What is the major difference between filtering in the `ON` clause vs `WHERE` clause in a `LEFT JOIN`?
```sql
-- Query 1:
SELECT * FROM Customers c LEFT JOIN Orders o ON c.id = o.customer_id AND o.status = 'ACTIVE';

-- Query 2:
SELECT * FROM Customers c LEFT JOIN Orders o ON c.id = o.customer_id WHERE o.status = 'ACTIVE';
```
- A) Both queries return identical results
- B) Query 1 returns ALL customers (preserving unmatched customers with NULL order columns); Query 2 filters out all unmatched customers because `NULL = 'ACTIVE'` evaluates to `UNKNOWN` in `WHERE`, effectively converting the `LEFT JOIN` into an `INNER JOIN`!
- C) Query 2 is invalid SQL
- D) Query 1 returns only active orders

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Query 1 returns ALL customers (preserving unmatched customers with NULL order columns); Query 2 filters out all unmatched customers because `NULL = 'ACTIVE'` evaluates to `UNKNOWN` in `WHERE`, effectively converting the `LEFT JOIN` into an `INNER JOIN`!**
**Explanation:** This is one of the most famous SQL interview questions! In a `LEFT JOIN`, predicates in the `ON` clause determine which right-table rows join, while preserving all left-table rows. Predicates in the `WHERE` clause filter the final result set AFTER the join.
</details>

---

### Q20. If Table A has 5 rows and Table B has 10 rows, how many rows are produced by `SELECT * FROM TableA CROSS JOIN TableB;`?
- A) 15
- B) 50
- C) 10
- D) 5

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) 50**
**Explanation:** A `CROSS JOIN` produces the Cartesian product of both tables. Total rows = $5 \times 10 = 50$.
</details>

---

### Q21. If Table A has values `(1, 1, 1)` and Table B has values `(1, 1)`, how many rows are returned by `SELECT * FROM TableA INNER JOIN TableB ON TableA.id = TableB.id;`?
- A) 3
- B) 6
- C) 5
- D) 1

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) 6**
**Explanation:** Every matching row in Table A joins with every matching row in Table B. $3 \text{ rows} \times 2 \text{ rows} = 6 \text{ rows}$.
</details>

---

### Q22. What is the difference between `UNION` and `UNION ALL`?
- A) `UNION` removes duplicate rows by performing an expensive distinct sorting/hash operation; `UNION ALL` simply concatenates all rows without checking for duplicates (significantly faster)
- B) `UNION ALL` removes duplicates
- C) `UNION` only works with numbers
- D) Both have the same performance

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) `UNION` removes duplicate rows by performing an expensive distinct sorting/hash operation; `UNION ALL` simply concatenates all rows without checking for duplicates (significantly faster)**
**Explanation:** Unless you strictly require distinct rows, always prefer `UNION ALL` for optimal performance.
</details>

---

### Q23. What does `FULL OUTER JOIN` return?
- A) Only matching rows between both tables
- B) All rows from the left table and all rows from the right table, matching rows where possible and filling `NULL` for missing sides
- C) Cartesian product
- D) Empty set

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) All rows from the left table and all rows from the right table, matching rows where possible and filling `NULL` for missing sides**
**Explanation:** `FULL OUTER JOIN` combines the results of both `LEFT OUTER JOIN` and `RIGHT OUTER JOIN`.
</details>

---

### Q24. How do you simulate a `FULL OUTER JOIN` in MySQL (which does not support `FULL OUTER JOIN` natively)?
- A) `LEFT JOIN UNION ALL RIGHT JOIN`
- B) `(SELECT ... LEFT JOIN ...) UNION (SELECT ... RIGHT JOIN ...)`
- C) `CROSS JOIN`
- D) `INNER JOIN`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `(SELECT ... LEFT JOIN ...) UNION (SELECT ... RIGHT JOIN ...)`**
**Explanation:** Taking a `LEFT JOIN` and combining it via `UNION` (which deduplicates overlapping inner join rows) with a `RIGHT JOIN` produces the exact equivalent of a `FULL OUTER JOIN`.
</details>

---

### Q25. What is a `NATURAL JOIN` in SQL and why is it considered dangerous in production?
- A) It joins tables on primary keys only
- B) It automatically joins tables based on all columns with identical names in both tables; if a schema change adds or renames columns, the join condition changes silently and breaks queries
- C) It is an unindexed join
- D) It only works in SQLite

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) It automatically joins tables based on all columns with identical names in both tables; if a schema change adds or renames columns, the join condition changes silently and breaks queries**
**Explanation:** `NATURAL JOIN` introduces implicit coupling to column names (e.g. if both tables have `created_at` or `status`, it will inadvertently join on those too). Always use explicit `ON a.id = b.a_id`.
</details>

---

### Q26. What does `INTERSECT` do in SQL?
- A) Combines all rows from both queries
- B) Returns only distinct rows that are present in BOTH query result sets
- C) Subtracts second query from first query
- D) Multiplies rows

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Returns only distinct rows that are present in BOTH query result sets**
**Explanation:** `INTERSECT` computes the set intersection of two `SELECT` queries with matching column types.
</details>

---

### Q27. What does `EXCEPT` (or `MINUS` in Oracle) do?
- A) Returns all rows from the first query that DO NOT exist in the second query
- B) Throws an exception
- C) Returns common rows
- D) Deletes rows from the database

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Returns all rows from the first query that DO NOT exist in the second query**
**Explanation:** `EXCEPT` (ANSI standard / PostgreSQL / SQL Server) and `MINUS` (Oracle) perform set difference.
</details>

---

### Q28. What is a Self-Join?
- A) A join between two tables in different databases
- B) Joining a table to itself (using table aliases) to evaluate hierarchical relationships or compare rows within the same table
- C) An automated join created by the database engine
- D) A join without an ON clause

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Joining a table to itself (using table aliases) to evaluate hierarchical relationships or compare rows within the same table**
**Explanation:** Classic example: Employee and Manager stored in the same `Employees` table (`SELECT e.name, m.name FROM Employees e LEFT JOIN Employees m ON e.manager_id = m.id`).
</details>

---

### Q29. What happens if you perform an `INNER JOIN` on a column that contains `NULL` values in both tables?
- A) Rows with `NULL` will join with other rows with `NULL`
- B) `NULL` rows will NEVER match because `NULL = NULL` is `UNKNOWN`, excluding them from inner join output
- C) Throws a NullPointerException
- D) Produces an infinite loop

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `NULL` rows will NEVER match because `NULL = NULL` is `UNKNOWN`, excluding them from inner join output**
**Explanation:** In standard SQL equality joins (`ON a.val = b.val`), `NULL` does not match `NULL`. To match nulls, you must write `ON (a.val = b.val OR (a.val IS NULL AND b.val IS NULL))` or use NULL-safe equality `<=>` in MySQL or `IS NOT DISTINCT FROM` in PostgreSQL/SQL:2003.
</details>

---

### Q30. What is the purpose of `IS NOT DISTINCT FROM` in PostgreSQL / SQL:2003?
- A) Standard equality check (`=`)
- B) A NULL-safe equality operator that evaluates `NULL IS NOT DISTINCT FROM NULL` as `TRUE`
- C) Case-sensitive string matching
- D) Pattern matching

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) A NULL-safe equality operator that evaluates `NULL IS NOT DISTINCT FROM NULL` as `TRUE`**
**Explanation:** `IS NOT DISTINCT FROM` treats `NULL` values as equal to other `NULL` values, eliminating verbose `OR (a IS NULL AND b IS NULL)` clauses in joins.
</details>

---

### Q31. Can a `LEFT JOIN` return more rows than exist in the left table?
- A) No, never
- B) Yes, if multiple matching rows exist in the right table for a single row in the left table (One-to-Many relationship)
- C) Only with subqueries
- D) Only in MySQL

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Yes, if multiple matching rows exist in the right table for a single row in the left table (One-to-Many relationship)**
**Explanation:** If 1 customer has 5 orders, a `LEFT JOIN` on `Customers` and `Orders` will duplicate that customer row 5 times.
</details>

---

### Q32. What is an Anti-Join in SQL?
- A) A join that returns rows from one table where NO matching rows exist in another table (e.g. `LEFT JOIN ... WHERE right.id IS NULL` or `NOT EXISTS`)
- B) A join that crashes the database
- C) A cross join
- D) A join without indexes

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) A join that returns rows from one table where NO matching rows exist in another table (e.g. `LEFT JOIN ... WHERE right.id IS NULL` or `NOT EXISTS`)**
**Explanation:** Anti-joins are optimized by database query planners to find unreferenced parent or orphan records efficiently.
</details>

---

## Section 3: Window Functions & Analytical Queries

### Q33. What is the difference between `ROW_NUMBER()`, `RANK()`, and `DENSE_RANK()` for values `(100, 100, 80, 70)`?
- A) `ROW_NUMBER`: 1, 2, 3, 4 | `RANK`: 1, 1, 3, 4 (skips 2) | `DENSE_RANK`: 1, 1, 2, 3 (no gaps)
- B) All three return identical results
- C) `DENSE_RANK` skips numbers
- D) `RANK` does not handle ties

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) `ROW_NUMBER`: 1, 2, 3, 4 | `RANK`: 1, 1, 3, 4 (skips 2) | `DENSE_RANK`: 1, 1, 2, 3 (no gaps)**
**Explanation:**
- `ROW_NUMBER()` assigns sequential unique integers regardless of ties.
- `RANK()` assigns identical ranks to ties, but leaves gaps in rank numbering.
- `DENSE_RANK()` assigns identical ranks to ties WITHOUT leaving any gaps.
</details>

---

### Q34. How do you find the 2nd Highest Salary in an `Employees` table using Window Functions?
```sql
WITH RankedSalaries AS (
    SELECT salary, DENSE_RANK() OVER (ORDER BY salary DESC) as rnk
    FROM Employees
)
SELECT salary FROM RankedSalaries WHERE rnk = 2 LIMIT 1;
```
- A) The query is correct and handles duplicate top salaries seamlessly
- B) Use `ROW_NUMBER()` instead of `DENSE_RANK()`
- C) Window functions cannot be used in CTEs
- D) `ORDER BY` is not allowed inside `OVER()`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) The query is correct and handles duplicate top salaries seamlessly**
**Explanation:** Using `DENSE_RANK()` ensures that if multiple employees share the highest salary (e.g. `$100K`, `$100K`), the next distinct salary level is correctly ranked as `2`.
</details>

---

### Q35. What does `LEAD(salary, 1, 0) OVER (ORDER BY hire_date)` return?
- A) The previous row's salary
- B) The next row's salary (following current row), with a default fallback of `0` if at the end of the partition
- C) The highest salary
- D) The first row's salary

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) The next row's salary (following current row), with a default fallback of `0` if at the end of the partition**
**Explanation:** `LEAD(col, offset, default)` looks forward by `offset` rows. `LAG(col, offset, default)` looks backward by `offset` rows.
</details>

---

### Q36. What is the default window frame clause when `ORDER BY` is present in an `OVER()` clause without explicit frame?
- A) `ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING`
- B) `RANGE BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW`
- C) `ROWS BETWEEN 1 PRECEDING AND 1 FOLLOWING`
- D) `ROWS BETWEEN CURRENT ROW AND UNBOUNDED FOLLOWING`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `RANGE BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW`**
**Explanation:** Because the default frame is `RANGE` (not `ROWS`) up to `CURRENT ROW`, calculating `SUM(amount) OVER (ORDER BY date)` computes a cumulative running total from the start of the partition up to the current row value.
</details>

---

### Q37. What is the difference between `ROWS` and `RANGE` in window frames?
- A) `ROWS` specifies physical row offsets; `RANGE` specifies logical value offsets (treating tied values as a single group)
- B) `RANGE` is faster than `ROWS`
- C) `ROWS` cannot use `PRECEDING`
- D) Both are identical

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) `ROWS` specifies physical row offsets; `RANGE` specifies logical value offsets (treating tied values as a single group)**
**Explanation:** If two rows have identical `ORDER BY` values, `ROWS BETWEEN ...` calculates them step-by-step per row, whereas `RANGE BETWEEN ...` aggregates all tied rows simultaneously.
</details>

---

### Q38. How do you calculate a 3-day Moving Average of sales?
```sql
SELECT sale_date, amount,
       AVG(amount) OVER (
           ORDER BY sale_date 
           ROWS BETWEEN 2 PRECEDING AND CURRENT ROW
       ) as moving_avg
FROM DailySales;
```
- A) This query correctly calculates the 3-day moving average (current day + 2 previous days)
- B) Syntax error on `PRECEDING`
- C) Moving averages cannot be computed in SQL
- D) `ROWS` must be replaced by `COLUMNS`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) This query correctly calculates the 3-day moving average (current day + 2 previous days)**
**Explanation:** `ROWS BETWEEN 2 PRECEDING AND CURRENT ROW` defines a sliding window frame consisting of exactly 3 physical rows.
</details>

---

### Q39. What does `NTILE(4) OVER (ORDER BY score DESC)` do?
- A) Multiplies scores by 4
- B) Divides the sorted rows into 4 approximately equal buckets (Quartiles), assigning bucket numbers 1 through 4
- C) Returns the top 4 rows
- D) Calculates 4 percentiles

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Divides the sorted rows into 4 approximately equal buckets (Quartiles), assigning bucket numbers 1 through 4**
**Explanation:** `NTILE(n)` is an analytical window function that partitions an ordered dataset into $n$ ranked buckets (e.g. deciles with `NTILE(10)`).
</details>

---

### Q40. Why does `LAST_VALUE(col) OVER (ORDER BY id)` often return the current row's value instead of the last row in the partition?
- A) `LAST_VALUE` is bugged in SQL
- B) Because the default window frame is `RANGE BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW`, which only looks up to the CURRENT row! To fix, specify `ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING`
- C) `LAST_VALUE` only works with dates
- D) `ORDER BY` must be `DESC`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Because the default window frame is `RANGE BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW`, which only looks up to the CURRENT row! To fix, specify `ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING`**
**Explanation:** This is a notorious SQL gotcha. Without expanding the frame to `UNBOUNDED FOLLOWING`, the "last value" in the current frame is simply the current row itself.
</details>

---

### Q41. Can window functions be used inside the `WHERE` clause directly?
```sql
SELECT name FROM Employees WHERE ROW_NUMBER() OVER (ORDER BY salary DESC) = 1;
```
- A) Yes, always valid
- B) No, window functions are evaluated AFTER the `WHERE` clause during logical query processing; you must wrap the query in a Subquery or CTE
- C) Only with `RANK()`
- D) Only in PostgreSQL

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) No, window functions are evaluated AFTER the `WHERE` clause during logical query processing; you must wrap the query in a Subquery or CTE**
**Explanation:** Because `WHERE` filters rows before window calculations are performed, window functions are prohibited in `WHERE` and `HAVING`.
</details>

---

### Q42. What does `PARTITION BY department_id` inside `OVER()` do?
- A) Splits physical storage on disk by department
- B) Divides the query result set into independent partitions/groups for which the window function is calculated separately, resetting row counts/ranks per department
- C) Sorts the department IDs
- D) Deletes duplicate departments

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Divides the query result set into independent partitions/groups for which the window function is calculated separately, resetting row counts/ranks per department**
**Explanation:** Unlike `GROUP BY` (which collapses rows into a single summary row), `PARTITION BY` in window functions preserves all individual rows while calculating aggregate metrics per group.
</details>

---

### Q43. What does `PERCENT_RANK()` return?
- A) The raw score percentage
- B) A relative rank of the row calculated as $(rank - 1) / (total\_rows - 1)$, ranging from `0.0` to `1.0`
- C) Multiplies rank by 100
- D) Percentile above 90

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) A relative rank of the row calculated as $(rank - 1) / (total\_rows - 1)$, ranging from `0.0` to `1.0`**
**Explanation:** `PERCENT_RANK()` computes the relative percentile rank of each row within the partition.
</details>

---

### Q44. What is the output of `FIRST_VALUE(employee_name) OVER (PARTITION BY dept_id ORDER BY salary DESC)`?
- A) The name of the highest-paid employee in each department
- B) The lowest-paid employee
- C) The department name
- D) The first employee hired

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) The name of the highest-paid employee in each department**
**Explanation:** `FIRST_VALUE` evaluates the first value in the sorted partition frame, which is the highest salary since it is ordered `DESC`.
</details>

---

### Q45. Can an aggregate function (like `SUM` or `COUNT`) be used as a window function?
- A) No, only analytical functions can be window functions
- B) Yes, appending `OVER (...)` to any standard aggregate function turns it into a window function that does not collapse rows
- C) Only with `COUNT`
- D) Only in MySQL 8+

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Yes, appending `OVER (...)` to any standard aggregate function turns it into a window function that does not collapse rows**
**Explanation:** `SUM(amount) OVER (PARTITION BY customer_id)` displays each individual transaction row alongside the customer's total spending.
</details>

---

### Q46. What does `CUME_DIST()` calculate?
- A) Cumulative distance
- B) The cumulative distribution of a value within a partition: the fraction of rows with values less than or equal to the current row's value ($0 < CUME\_DIST \le 1$)
- C) Number of customers
- D) Distinct count

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) The cumulative distribution of a value within a partition: the fraction of rows with values less than or equal to the current row's value ($0 < CUME\_DIST \le 1$)**
**Explanation:** Useful for determining percentile rankings (e.g. students scoring in the top 10% of their class).
</details>

---

### Q47. What does `LAG(val, 2)` do?
- A) Fetches the value from 2 rows AFTER the current row
- B) Fetches the value from 2 rows BEFORE the current row
- C) Adds 2 to the value
- D) Delays query execution by 2 seconds

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Fetches the value from 2 rows BEFORE the current row**
**Explanation:** The second parameter in `LAG(col, offset)` is the offset, specifying how many rows prior to look back.
</details>

---

### Q48. Is `OVER ()` with an empty specification valid?
```sql
SELECT name, salary, AVG(salary) OVER () as overall_avg FROM Employees;
```
- A) Invalid syntax
- B) Valid: Treats the entire result set as a single partition without ordering, attaching the grand average salary to every individual row
- C) Returns 0
- D) Fails without PARTITION BY

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Valid: Treats the entire result set as a single partition without ordering, attaching the grand average salary to every individual row**
**Explanation:** An empty `OVER ()` creates a window encompassing all rows returned by the query.
</details>

---

## Section 4: Subqueries, CTEs & Advanced Querying

### Q49. What is a Correlated Subquery?
- A) A subquery that executes once before the outer query
- B) A subquery that references columns from the outer query, executing once for every candidate row evaluated by the outer query
- C) A subquery inside the FROM clause
- D) A recursive query

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) A subquery that references columns from the outer query, executing once for every candidate row evaluated by the outer query**
**Explanation:** Correlated subqueries depend on outer query column values (e.g. `WHERE e.salary > (SELECT AVG(salary) FROM Employees WHERE dept_id = e.dept_id)`).
</details>

---

### Q50. What is a Common Table Expression (CTE)?
- A) A temporary named result set defined within the execution scope of a single `WITH` statement
- B) A permanent database table
- C) A stored procedure
- D) A database trigger

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) A temporary named result set defined within the execution scope of a single `WITH` statement**
**Explanation:** CTEs (`WITH cte_name AS (...)`) improve query readability, enable recursive operations, and can be referenced multiple times in the main query.
</details>

---

### Q51. How does a Recursive CTE (`WITH RECURSIVE`) work?
- A) Runs an infinite loop
- B) Consists of an **Anchor Member** (base query), followed by `UNION ALL`, followed by a **Recursive Member** that references the CTE itself until an empty result set is produced
- C) Uses Java recursion
- D) Requires database restarts

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Consists of an **Anchor Member** (base query), followed by `UNION ALL`, followed by a **Recursive Member** that references the CTE itself until an empty result set is produced**
**Explanation:** Recursive CTEs are the standard mechanism in SQL for traversing tree hierarchies (e.g. Org charts, bill-of-materials, category trees).
</details>

---

### Q52. What is the difference between `EXISTS` and `IN` with subqueries?
- A) `EXISTS` terminates evaluation as soon as the first matching row is found (short-circuit boolean check); `IN` evaluates all values in the subquery list (and has NULL hazards with NOT IN)
- B) `IN` is always faster
- C) `EXISTS` returns data values
- D) `IN` cannot be used with subqueries

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) `EXISTS` terminates evaluation as soon as the first matching row is found (short-circuit boolean check); `IN` evaluates all values in the subquery list (and has NULL hazards with NOT IN)**
**Explanation:** Modern optimizers often rewrite `IN` to `EXISTS`, but `EXISTS` is safer and often superior when checking existence against large tables with possible NULLs.
</details>

---

### Q53. What does `SELECT * FROM Employees WHERE salary > ALL (SELECT salary FROM Employees WHERE dept_id = 5);` do?
- A) Returns employees whose salary is greater than the MAXIMUM salary in department 5
- B) Returns employees whose salary is greater than the MINIMUM salary in department 5
- C) Returns all employees in department 5
- D) Throws a syntax error

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Returns employees whose salary is greater than the MAXIMUM salary in department 5**
**Explanation:** `> ALL` requires the value to be greater than every single value in the subquery list (equivalent to `> MAX(...)`). Conversely, `> ANY` is equivalent to `> MIN(...)`.
</details>

---

### Q54. What does `> ANY (SELECT salary FROM ...)` do?
- A) Greater than every value
- B) Greater than at least one value (equivalent to `> MIN(...)`)
- C) Equals any value
- D) Invalid syntax

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Greater than at least one value (equivalent to `> MIN(...)`)**
**Explanation:** `ANY` (or `SOME`) evaluates to `TRUE` if the comparison holds for at least one element returned by the subquery.
</details>

---

### Q55. What is the difference between a Temporary Table and a Table Variable / CTE?
- A) Temporary tables (`#temp` or `CREATE TEMP TABLE`) are materialized in `tempdb`/storage, can have indexes and statistics, and persist across multiple queries in the session; CTEs exist only for a single SQL statement
- B) CTEs are stored on disk permanently
- C) Temporary tables cannot be indexed
- D) Both are identical

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Temporary tables (`#temp` or `CREATE TEMP TABLE`) are materialized in `tempdb`/storage, can have indexes and statistics, and persist across multiple queries in the session; CTEs exist only for a single SQL statement**
**Explanation:** For massive intermediate datasets referenced repeatedly, indexing a temporary table often outperforms re-evaluating complex CTEs.
</details>

---

### Q56. How can you delete duplicate rows in a table while keeping only 1 instance?
```sql
WITH CTE AS (
    SELECT id, ROW_NUMBER() OVER (PARTITION BY email ORDER BY id) as rn
    FROM Users
)
DELETE FROM CTE WHERE rn > 1;
```
- A) This query correctly deletes duplicate emails, keeping the lowest `id` per email
- B) CTEs cannot be deleted in SQL
- C) `ROW_NUMBER()` cannot identify duplicates
- D) Syntax error

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) This query correctly deletes duplicate emails, keeping the lowest `id` per email**
**Explanation:** In SQL Server / PostgreSQL / Oracle (using updatable CTEs or subqueries), partitioning by duplicate columns and deleting rows with `ROW_NUMBER() > 1` is the standard deduplication pattern.
</details>

---

### Q57. What is the difference between `EXISTS (SELECT 1 ...)` and `EXISTS (SELECT * ...)`?
- A) `SELECT 1` is 10x faster
- B) There is NO difference in performance; the query optimizer ignores the `SELECT` list in an `EXISTS` subquery because it only checks for the existence of at least 1 matching row
- C) `SELECT *` throws an error
- D) `SELECT 1` is deprecated

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) There is NO difference in performance; the query optimizer ignores the `SELECT` list in an `EXISTS` subquery because it only checks for the existence of at least 1 matching row**
**Explanation:** The optimizer treats `EXISTS (SELECT 1 ...)`, `EXISTS (SELECT * ...)`, and `EXISTS (SELECT NULL ...)` identically.
</details>

---

### Q58. What is a Lateral Join (`CROSS APPLY` in SQL Server / `JOIN LATERAL` in PostgreSQL)?
- A) A join that allows the right-hand subquery/function to reference columns from left-hand table rows preceding it (like a correlated subquery in the FROM clause)
- B) A join that swaps columns
- C) A join across network sockets
- D) A full outer join

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) A join that allows the right-hand subquery/function to reference columns from left-hand table rows preceding it (like a correlated subquery in the FROM clause)**
**Explanation:** `LATERAL` / `CROSS APPLY` allows executing table-valued functions or top-N subqueries for each row in the left table (e.g. Top 3 orders for every customer).
</details>

---

### Q59. What does the following query find?
```sql
SELECT department_id, AVG(salary) 
FROM Employees e1
GROUP BY department_id
HAVING AVG(salary) > (SELECT AVG(salary) FROM Employees);
```
- A) Departments whose average salary is higher than the overall company-wide average salary
- B) All employees earning above average
- C) The highest earning department only
- D) Syntax error in HAVING

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Departments whose average salary is higher than the overall company-wide average salary**
**Explanation:** The `HAVING` clause compares each department's aggregated average against the scalar result of the subquery calculating the global company average.
</details>

---

### Q60. How do you find the N-th highest salary without window functions using pure standard SQL?
```sql
SELECT DISTINCT salary 
FROM Employees e1
WHERE (N - 1) = (
    SELECT COUNT(DISTINCT salary) 
    FROM Employees e2 
    WHERE e2.salary > e1.salary
);
```
- A) The query is mathematically correct
- B) It only works for N = 1
- C) Subqueries cannot count distinct values
- D) Syntax error

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) The query is mathematically correct**
**Explanation:** For the $N$-th highest salary, there are exactly $N - 1$ distinct salaries strictly greater than it. For $N=2$ (2nd highest), exactly 1 distinct salary is greater.
</details>

---

### Q61. Can a subquery return multiple columns when used in a `WHERE col = (...)` condition?
- A) Yes, always
- B) No, a subquery used with scalar comparison operators (`=`, `>`, `<`) must be a scalar subquery (returning at most 1 row and 1 column), otherwise it throws a runtime error (e.g. `subquery returned more than 1 value`)
- C) Only with strings
- D) Only in SQLite

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) No, a subquery used with scalar comparison operators (`=`, `>`, `<`) must be a scalar subquery (returning at most 1 row and 1 column), otherwise it throws a runtime error (e.g. `subquery returned more than 1 value`)**
**Explanation:** Scalar comparisons require single values. Multiple rows require `IN` or `ANY`; multiple columns require row constructor comparisons (e.g. `WHERE (colA, colB) IN (SELECT ...)`).
</details>

---

### Q62. What happens if a scalar subquery returns 0 rows?
- A) Evaluates to `NULL`
- B) Throws an exception
- C) Evaluates to `0`
- D) Evaluates to empty string

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Evaluates to `NULL`**
**Explanation:** In standard SQL, if a scalar subquery in an expression yields no rows, its value is evaluated as `NULL`.
</details>

---

### Q63. What is a View in SQL?
- A) A stored virtual table defined by a SQL query that does not store data itself (unless materialized/indexed), executing the underlying query when accessed
- B) A physical copy of data
- C) A database backup
- D) A client UI window

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) A stored virtual table defined by a SQL query that does not store data itself (unless materialized/indexed), executing the underlying query when accessed**
**Explanation:** Views encapsulate complex queries and provide security boundaries. **Materialized Views** physically store the computed result on disk and must be refreshed.
</details>

---

### Q64. What is a Materialized View?
- A) A view that updates HTML templates
- B) A view whose result set is physically computed and stored on disk, allowing fast query performance at the cost of requiring periodic refreshes
- C) A view created in memory only
- D) A view without tables

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) A view whose result set is physically computed and stored on disk, allowing fast query performance at the cost of requiring periodic refreshes**
**Explanation:** Materialized views are crucial in Data Warehousing and OLAP systems for pre-computing expensive aggregations across millions of rows.
</details>

---

### Q65. What is the SQL clause `WITH CHECK OPTION` on an updatable View?
- A) Checks database integrity
- B) Prevents `INSERT` or `UPDATE` operations through the view that would produce rows not visible within the view's defining `WHERE` clause
- C) Disables transactions
- D) Validates data types

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Prevents `INSERT` or `UPDATE` operations through the view that would produce rows not visible within the view's defining `WHERE` clause**
**Explanation:** If a view is defined as `WHERE active = true WITH CHECK OPTION`, attempting to update a row to `active = false` through the view is rejected.
</details>

---

## Section 5: Aggregation, Grouping & Multidimensional Analytics

### Q66. What is the difference between `WHERE` and `HAVING`?
- A) `WHERE` filters individual rows BEFORE aggregation; `HAVING` filters aggregated groups AFTER the `GROUP BY` clause is evaluated
- B) `HAVING` can only be used with primary keys
- C) `WHERE` is for numbers; `HAVING` is for strings
- D) There is no difference

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) `WHERE` filters individual rows BEFORE aggregation; `HAVING` filters aggregated groups AFTER the `GROUP BY` clause is evaluated**
**Explanation:** You cannot use aggregate functions (`SUM`, `COUNT`, `AVG`) in a `WHERE` clause, but you CAN use them in a `HAVING` clause (`HAVING COUNT(*) > 5`).
</details>

---

### Q67. What does `GROUP BY ROLLUP(region, year)` generate?
- A) Grouping by region only
- B) Hierarchical sub-totals: `(region, year)`, `(region)`, and the grand total `()`
- C) Cartesian product of all groups
- D) Deletes summary rows

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Hierarchical sub-totals: `(region, year)`, `(region)`, and the grand total `()`**
**Explanation:** `ROLLUP` produces hierarchical aggregations from right to left, ending with the grand total.
</details>

---

### Q68. What does `GROUP BY CUBE(region, year)` generate?
- A) All $2^N$ possible combinations of sub-totals: `(region, year)`, `(region)`, `(year)`, and the grand total `()`
- B) Only 3D data
- C) Hierarchical sub-totals only
- D) Same as GROUP BY

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) All $2^N$ possible combinations of sub-totals: `(region, year)`, `(region)`, `(year)`, and the grand total `()`**
**Explanation:** `CUBE` computes aggregations across all permutations of the specified columns.
</details>

---

### Q69. What does the `GROUPING()` function indicate when used with `ROLLUP` or `CUBE`?
- A) Returns `1` if the column value in the output row represents a generated aggregated subtotal (super-aggregate) for that column, or `0` if it represents actual row data
- B) Groups strings
- C) Returns the number of groups
- D) Multiplies group totals

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Returns `1` if the column value in the output row represents a generated aggregated subtotal (super-aggregate) for that column, or `0` if it represents actual row data**
**Explanation:** `GROUPING(col)` allows replacing `NULL` in subtotal rows with labels like `'ALL REGIONS'` via `CASE WHEN GROUPING(region) = 1 THEN 'All Regions' ELSE region END`.
</details>

---

### Q70. How do you pivot rows into columns in standard SQL?
```sql
SELECT year,
       SUM(CASE WHEN quarter = 'Q1' THEN revenue ELSE 0 END) as Q1_Revenue,
       SUM(CASE WHEN quarter = 'Q2' THEN revenue ELSE 0 END) as Q2_Revenue
FROM Sales
GROUP BY year;
```
- A) Conditional aggregation using `SUM(CASE WHEN ...)`
- B) Using `PIVOT` operator (in supported dialects like SQL Server/Oracle)
- C) Both A and B are valid
- D) SQL cannot pivot rows into columns

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **C) Both A and B are valid**
**Explanation:** Conditional aggregation with `CASE WHEN` is universal across all SQL databases. Dedicated `PIVOT` clauses exist in SQL Server/Oracle.
</details>

---

### Q71. Can a `HAVING` clause exist in a query WITHOUT a `GROUP BY` clause?
```sql
SELECT 'Alert' FROM Employees HAVING AVG(salary) > 50000;
```
- A) Invalid syntax; `HAVING` requires `GROUP BY`
- B) Valid: Treats the entire table as a single implicit group
- C) Returns error only in PostgreSQL
- D) Throws runtime exception

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Valid: Treats the entire table as a single implicit group**
**Explanation:** When `HAVING` is used without `GROUP BY`, the entire table forms a single group. If the condition is met, 1 row is returned; otherwise 0 rows.
</details>

---

### Q72. How do you concatenate string values from multiple rows into a single comma-separated string in PostgreSQL vs MySQL?
- A) `STRING_AGG(name, ', ')` in PostgreSQL; `GROUP_CONCAT(name SEPARATOR ', ')` in MySQL
- B) `CONCAT_ROWS()`
- C) `JOIN_STRINGS()`
- D) `SUM(name)`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) `STRING_AGG(name, ', ')` in PostgreSQL; `GROUP_CONCAT(name SEPARATOR ', ')` in MySQL**
**Explanation:** In SQL Server, `STRING_AGG(name, ', ')` is used; in Oracle, `LISTAGG(name, ', ') WITHIN GROUP (ORDER BY name)` is used.
</details>

---

### Q73. What is the result of `SELECT SUM(salary) FROM Employees WHERE 1 = 2;` vs `SELECT COUNT(salary) FROM Employees WHERE 1 = 2;`?
- A) `NULL` and `0`
- B) `0` and `0`
- C) `NULL` and `NULL`
- D) Empty set and empty set

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) `NULL` and `0`**
**Explanation:** `COUNT()` on an empty set always returns `0`. All other aggregate functions (`SUM`, `AVG`, `MIN`, `MAX`) return `NULL` when operating on an empty set!
</details>

---

### Q74. What is the rule regarding non-aggregated columns in a `SELECT` list when `GROUP BY` is used?
- A) Any column appearing in `SELECT` must either appear in the `GROUP BY` clause or be wrapped inside an aggregate function
- B) Any column can be selected freely
- C) Only numeric columns are allowed
- D) Maximum 3 columns allowed

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Any column appearing in `SELECT` must either appear in the `GROUP BY` clause or be wrapped inside an aggregate function**
**Explanation:** Selecting a non-aggregated column that is not part of `GROUP BY` creates ambiguity (which row's value should be displayed for the group?). Modern SQL engines reject this under `ONLY_FULL_GROUP_BY` mode.
</details>

---

### Q75. What does `COUNT(DISTINCT country)` do when the column contains `NULL` values?
- A) Includes NULL as 1 distinct value
- B) Ignores NULL and counts only distinct non-null country names
- C) Throws an exception
- D) Returns 0

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Ignores NULL and counts only distinct non-null country names**
**Explanation:** Like standard `COUNT(col)`, `COUNT(DISTINCT col)` ignores `NULL`s.
</details>

---

### Q76. What does `GROUPING SETS ((dept_id), (job_title), ())` do?
- A) Computes exact aggregations for specified groupings in a single pass without needing separate UNION queries
- B) Creates temporary tables
- C) Sorts the result set
- D) Removes nulls

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Computes exact aggregations for specified groupings in a single pass without needing separate UNION queries**
**Explanation:** `GROUPING SETS` lets you specify precise grouping combinations explicitly.
</details>

---

### Q77. What is the output of `MIN(col)` and `MAX(col)` on String/VARCHAR columns?
- A) Throws an error (only for numbers)
- B) Returns the lexicographically (alphabetically) first and last string according to database collation
- C) Returns the shortest and longest string by length
- D) Returns null

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Returns the lexicographically (alphabetically) first and last string according to database collation**
**Explanation:** `MIN('Zebra', 'Apple')` yields `'Apple'`. To find string lengths, use `MIN(LENGTH(col))`.
</details>

---

### Q78. Can you use `DISTINCT` inside `AVG()` (e.g. `AVG(DISTINCT salary)`)?
- A) Yes, it calculates the average of only unique salary amounts, ignoring duplicates
- B) No, DISTINCT only works with COUNT
- C) Invalid syntax
- D) Only in Oracle

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Yes, it calculates the average of only unique salary amounts, ignoring duplicates**
**Explanation:** All aggregate functions (`SUM(DISTINCT x)`, `AVG(DISTINCT x)`, `COUNT(DISTINCT x)`) accept `DISTINCT`.
</details>

---

## Section 6: Indexing, SARGability & Query Optimization

### Q79. What is a SARGable query (Search Argument Able)?
- A) A query that can exploit B-Tree indexes efficiently to perform fast Index Seeks rather than slow Full Table/Index Scans
- B) A query that runs in parallel
- C) A secured query against SQL Injection
- D) An asynchronous query

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) A query that can exploit B-Tree indexes efficiently to perform fast Index Seeks rather than slow Full Table/Index Scans**
**Explanation:** SARGable queries format predicates so the indexed column remains unmodified (e.g. `WHERE create_date >= '2024-01-01'` is SARGable; `WHERE YEAR(create_date) = 2024` is NON-SARGable because wrapping the column in a function prevents index lookup).
</details>

---

### Q80. Why is `WHERE phone_number LIKE '%555'` non-SARGable?
- A) Because the `%` wildcard
- B) Leading wildcards (`%text`) prevent the B-Tree index from traversing from root to leaf, forcing a full table/index scan
- C) `LIKE` is only for numbers
- D) Phone numbers cannot be indexed

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Leading wildcards (`%text`) prevent the B-Tree index from traversing from root to leaf, forcing a full table/index scan**
**Explanation:** B-Tree indexes are sorted from left to right. Trailing wildcards (`'555%'`) perform fast index range seeks; leading wildcards (`'%555'`) require scanning every entry.
</details>

---

### Q81. What is the Leftmost Prefix Rule (Composite Index Rule)?
- A) If an index is created on `(colA, colB, colC)`, the database can use the index for queries filtering on `(colA)`, `(colA, colB)`, or `(colA, colB, colC)`, but CANNOT use it efficiently for queries filtering only on `(colB)` or `(colC)`
- B) All column names must start with letters on the left
- C) Only 3 columns allowed per index
- D) Indexes only sort from left to right

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) If an index is created on `(colA, colB, colC)`, the database can use the index for queries filtering on `(colA)`, `(colA, colB)`, or `(colA, colB, colC)`, but CANNOT use it efficiently for queries filtering only on `(colB)` or `(colC)`**
**Explanation:** A composite index is sorted primarily by `colA`, secondarily by `colB`, and tertiarily by `colC`. Without `colA`, the sorted order of `colB` is useless for direct seeks.
</details>

---

### Q82. What is a Covering Index (Index-Only Scan)?
- A) An index that covers every table in the database
- B) An index that contains all columns requested by a query (`SELECT`, `WHERE`, `JOIN`), allowing the engine to satisfy the entire query directly from index pages without accessing the main table data pages (eliminating table lookups)
- C) A clustered index
- D) An encrypted index

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) An index that contains all columns requested by a query (`SELECT`, `WHERE`, `JOIN`), allowing the engine to satisfy the entire query directly from index pages without accessing the main table data pages (eliminating table lookups)**
**Explanation:** Index-Only Scans avoid expensive random I/O heap/table lookups (often achieved using `INCLUDE` columns in SQL Server/PostgreSQL).
</details>

---

### Q83. What is the difference between a Clustered Index and a Non-Clustered (Secondary) Index?
- A) A **Clustered Index** physically dictates the storage order of table data rows on disk (only 1 per table); a **Non-Clustered Index** is a separate sorted structure storing index keys with pointers back to the physical data rows (multiple allowed per table)
- B) Non-clustered indexes store data rows directly
- C) Clustered indexes cannot be unique
- D) There can be 10 clustered indexes per table

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) A **Clustered Index** physically dictates the storage order of table data rows on disk (only 1 per table); a **Non-Clustered Index** is a separate sorted structure storing index keys with pointers back to the physical data rows (multiple allowed per table)**
**Explanation:** In MySQL InnoDB, the Primary Key is always the Clustered Index (leaf nodes contain complete table rows). Secondary indexes point to the Primary Key.
</details>

---

### Q84. What is Index Cardinality?
- A) The number of indexes on a table
- B) The uniqueness / number of distinct values in an indexed column relative to total rows (high cardinality = high uniqueness, like IDs/emails; low cardinality = low uniqueness, like gender/boolean flags)
- C) The size of the index on disk in MB
- D) The depth of the B-tree

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) The uniqueness / number of distinct values in an indexed column relative to total rows (high cardinality = high uniqueness, like IDs/emails; low cardinality = low uniqueness, like gender/boolean flags)**
**Explanation:** B-Tree indexes are most effective on high-cardinality columns. For low-cardinality columns (e.g. `is_active`), the query planner often chooses a full table scan instead.
</details>

---

### Q85. What does `EXPLAIN` or `EXPLAIN ANALYZE` show?
- A) Explains SQL syntax errors
- B) Generates the Query Execution Plan showing cost estimates, join algorithms (Nested Loop, Hash Join, Merge Join), scan types (Seq Scan, Index Scan), and actual execution runtime
- C) Defragments indexes
- D) Generates database documentation

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Generates the Query Execution Plan showing cost estimates, join algorithms (Nested Loop, Hash Join, Merge Join), scan types (Seq Scan, Index Scan), and actual execution runtime**
**Explanation:** `EXPLAIN` shows the optimizer's estimated plan; `EXPLAIN ANALYZE` actually executes the query and compares estimated costs against actual timing and row counts.
</details>

---

### Q86. Why can having too many indexes degrade database performance?
- A) Indexes consume disk space and slow down `INSERT`, `UPDATE`, and `DELETE` (DML) operations because every write must update all associated index B-Trees
- B) Indexes crash the CPU
- C) Indexes prevent queries from caching
- D) Indexes lock the database permanently

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Indexes consume disk space and slow down `INSERT`, `UPDATE`, and `DELETE` (DML) operations because every write must update all associated index B-Trees**
**Explanation:** Indexing is a trade-off: it speeds up reads (`SELECT`) while adding overhead to writes (`INSERT`/`UPDATE`/`DELETE`).
</details>

---

### Q87. When is a Full Table Scan (Seq Scan) faster than an Index Scan?
- A) When querying a table with only a few rows or when retrieving a large percentage (e.g. > 20-30%) of the total rows in a table (sequential I/O beats millions of random index lookups)
- B) Full Table Scans are never faster
- C) Only when indexes are corrupted
- D) Only on SSDs

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) When querying a table with only a few rows or when retrieving a large percentage (e.g. > 20-30%) of the total rows in a table (sequential I/O beats millions of random index lookups)**
**Explanation:** Sequential page reads in bulk are significantly faster than hopping back and forth between secondary index pages and table data pages.
</details>

---

### Q88. What is the difference between a Hash Join, Merge Join, and Nested Loop Join?
- A) **Nested Loop**: Fast for small outer table with indexed inner table; **Hash Join**: Builds in-memory hash table of smaller dataset for large unsorted joins; **Merge Join**: Merges two pre-sorted datasets
- B) Hash joins are only for strings
- C) Merge joins require random data
- D) Nested loops only work with 1 row

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) **Nested Loop**: Fast for small outer table with indexed inner table; **Hash Join**: Builds in-memory hash table of smaller dataset for large unsorted joins; **Merge Join**: Merges two pre-sorted datasets**
**Explanation:** Database query optimizers choose among these 3 join strategies based on table statistics, data sizes, and existing index sorting.
</details>

---

### Q89. What is a Partial / Filtered Index?
```sql
CREATE INDEX idx_unprocessed_orders ON Orders (created_at) WHERE status = 'PENDING';
```
- A) An index created only on a subset of table rows matching a specific `WHERE` predicate, saving disk space and speeding up targeted queries
- B) An unfinished index
- C) An index on 1 column
- D) A temporary index

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) An index created only on a subset of table rows matching a specific `WHERE` predicate, saving disk space and speeding up targeted queries**
**Explanation:** Filtered indexes (supported in PostgreSQL and SQL Server) are ideal for indexing rare statuses (e.g. only 1% of orders are `PENDING`).
</details>

---

### Q90. What is an Implicit Type Conversion index trap?
```sql
-- Assume `user_id` column is VARCHAR(20) and indexed
SELECT * FROM Users WHERE user_id = 12345; -- passed as integer literal
```
- A) Works with fast index seek
- B) The database converts `user_id` to integer by applying an implicit conversion function across all rows (`CAST(user_id AS INT) = 12345`), breaking index usage and causing a full table scan
- C) Throws a compilation error
- D) Deletes user 12345

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) The database converts `user_id` to integer by applying an implicit conversion function across all rows (`CAST(user_id AS INT) = 12345`), breaking index usage and causing a full table scan**
**Explanation:** Always ensure parameter types match the column data type (`WHERE user_id = '12345'`) to prevent silent performance degradation.
</details>

---

### Q91. What is a Bitmap Index and where is it typically used?
- A) An index using bit arrays for low-cardinality columns (e.g. `Gender`, `MaritalStatus`), predominantly used in read-heavy Data Warehouses / OLAP systems
- B) An index for storing JPEG images
- C) An index for primary keys
- D) An index used exclusively in MySQL

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) An index using bit arrays for low-cardinality columns (e.g. `Gender`, `MaritalStatus`), predominantly used in read-heavy Data Warehouses / OLAP systems**
**Explanation:** Bitmap indexes allow fast boolean bitwise operations (`AND`, `OR`, `NOT`) across multiple filters, but cause heavy locking on concurrent writes.
</details>

---

### Q92. What does Database Index Fragmentation mean and how is it resolved?
- A) Out-of-order physical leaf pages caused by frequent `INSERT`, `UPDATE`, and `DELETE` page splits, resolved by running `REINDEX` or `ALTER INDEX ... REBUILD`
- B) Broken hard drives
- C) Memory leaks in connection pool
- D) Corrupted SQL queries

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Out-of-order physical leaf pages caused by frequent `INSERT`, `UPDATE`, and `DELETE` page splits, resolved by running `REINDEX` or `ALTER INDEX ... REBUILD`**
**Explanation:** Index rebuilding reorders leaf nodes contiguously and compacts data pages.
</details>

---

## Section 7: Transactions, ACID, Locking & Normalization

### Q93. What does ACID stand for in Database Systems?
- A) Array, Cursor, Index, Data
- B) Atomicity, Consistency, Isolation, Durability
- C) Asynchronous, Concurrent, Isolated, Distributed
- D) Access, Control, Integrity, Definition

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Atomicity, Consistency, Isolation, Durability**
**Explanation:**
- **Atomicity**: All operations succeed or all roll back ("All-or-Nothing").
- **Consistency**: Database transitions from one valid state to another, enforcing constraints.
- **Isolation**: Concurrent transactions do not interfere with each other.
- **Durability**: Committed data survives power loss/crashes (written to WAL / redo logs).
</details>

---

### Q94. What is a "Dirty Read"?
- A) Reading data from a corrupted disk
- B) A transaction reads uncommitted changes written by another concurrent transaction (which might subsequently roll back)
- C) Reading old cached data
- D) Reading data without an index

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) A transaction reads uncommitted changes written by another concurrent transaction (which might subsequently roll back)**
**Explanation:** Prevented by `READ COMMITTED` and higher isolation levels.
</details>

---

### Q95. What is a "Non-Repeatable Read"?
- A) A transaction reads the same row twice and receives different column values because another transaction modified and committed that row in between
- B) An error reading from a read-only replica
- C) A transaction reading uncommitted rows
- D) Reading duplicate rows

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) A transaction reads the same row twice and receives different column values because another transaction modified and committed that row in between**
**Explanation:** Prevented by `REPEATABLE READ` and `SERIALIZABLE` isolation levels.
</details>

---

### Q96. What is a "Phantom Read"?
- A) A transaction re-executes a range query (`WHERE age > 30`) and finds NEW rows inserted and committed by another transaction in between
- B) A ghost record on disk
- C) Reading data from deleted tables
- D) A deadlock exception

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) A transaction re-executes a range query (`WHERE age > 30`) and finds NEW rows inserted and committed by another transaction in between**
**Explanation:** `REPEATABLE READ` locks existing rows, but in standard SQL, only `SERIALIZABLE` (via Range Locks / Predicate Locks / MVCC snapshot isolation) prevents newly inserted phantom rows.
</details>

---

### Q97. Which Transaction Isolation Level is the default in PostgreSQL vs MySQL InnoDB?
- A) PostgreSQL: `READ COMMITTED`; MySQL: `REPEATABLE READ`
- B) PostgreSQL: `SERIALIZABLE`; MySQL: `READ UNCOMMITTED`
- C) Both default to `READ UNCOMMITTED`
- D) Both default to `SERIALIZABLE`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) PostgreSQL: `READ COMMITTED`; MySQL: `REPEATABLE READ`**
**Explanation:** PostgreSQL defaults to `READ COMMITTED`. MySQL InnoDB defaults to `REPEATABLE READ` (which uses Next-Key Locks to prevent phantom reads).
</details>

---

### Q98. What is MVCC (Multi-Version Concurrency Control)?
- A) A database concurrency mechanism where readers do not block writers and writers do not block readers by maintaining multiple version snapshots of data rows
- B) Version control for database schema scripts (like Git)
- C) Multiple database servers running together
- D) Multi-threaded CPU locking

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) A database concurrency mechanism where readers do not block writers and writers do not block readers by maintaining multiple version snapshots of data rows**
**Explanation:** Used in PostgreSQL, MySQL InnoDB, and Oracle. When a row is updated, a new version is created; reading transactions see a consistent historical snapshot without acquiring read locks.
</details>

---

### Q99. What is a Deadlock in SQL and how does the database handle it?
- A) Two transactions each hold a lock the other requires; the database deadlock detector detects the cycle and automatically aborts / rolls back one transaction (the "victim") with an error
- B) Database crashes
- C) Both transactions wait forever
- D) All data is wiped

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Two transactions each hold a lock the other requires; the database deadlock detector detects the cycle and automatically aborts / rolls back one transaction (the "victim") with an error**
**Explanation:** Applications should handle deadlock errors (e.g. error 1213 in MySQL / 40P01 in Postgres) by catching and retrying the transaction.
</details>

---

### Q100. What does `SELECT ... FOR UPDATE` do?
- A) Updates the table immediately
- B) Acquires an Exclusive Row-Level Lock (Pessimistic Lock) on matching rows, preventing other transactions from updating, deleting, or locking those rows until the current transaction commits
- C) Creates a backup
- D) Unlocks the table

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Acquires an Exclusive Row-Level Lock (Pessimistic Lock) on matching rows, preventing other transactions from updating, deleting, or locking those rows until the current transaction commits**
**Explanation:** `SELECT ... FOR UPDATE` is the foundation of pessimistic locking for financial ledger deductions and inventory seat reservations.
</details>

---

### Q101. What is the difference between a Primary Key and a Unique Key constraint?
- A) A table can have only ONE Primary Key (and columns cannot contain `NULL`); a table can have MULTIPLE Unique Keys (and unique key columns CAN contain `NULL` values)
- B) Unique keys cannot be indexed
- C) Primary keys are only for numbers
- D) Both are identical

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) A table can have only ONE Primary Key (and columns cannot contain `NULL`); a table can have MULTIPLE Unique Keys (and unique key columns CAN contain `NULL` values)**
**Explanation:** In standard SQL, a Unique constraint allows multiple `NULL` values because `NULL != NULL` (though in SQL Server, a unique index allows only one `NULL` unless created as a filtered index).
</details>

---

### Q102. What is Third Normal Form (3NF)?
- A) A table is in 2NF and has NO transitive functional dependencies (all non-key attributes depend ONLY on the primary key, directly and non-transitively)
- B) All tables have 3 columns
- C) No duplicate rows
- D) Tables have no foreign keys

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) A table is in 2NF and has NO transitive functional dependencies (all non-key attributes depend ONLY on the primary key, directly and non-transitively)**
**Explanation:** "Every non-key attribute must provide a fact about the key, the whole key, and nothing but the key, so help me Codd."
</details>

---

### Q103. What is the difference between `ON DELETE CASCADE` and `ON DELETE SET NULL` on a Foreign Key?
- A) `ON DELETE CASCADE` automatically deletes dependent child rows when the parent row is deleted; `ON DELETE SET NULL` updates the child foreign key column to `NULL` while keeping the child rows
- B) `CASCADE` deletes the entire database
- C) `SET NULL` is not supported in SQL
- D) Both delete the parent table

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) `ON DELETE CASCADE` automatically deletes dependent child rows when the parent row is deleted; `ON DELETE SET NULL` updates the child foreign key column to `NULL` while keeping the child rows**
**Explanation:** These referential integrity actions automate foreign key maintenance upon parent row deletion.
</details>

---

### Q104. What is Database Sharding?
- A) Horizontal partitioning where data is split across multiple independent physical database servers / instances based on a shard key (e.g. `user_id % num_shards`)
- B) Creating table backups on USB drives
- C) Normalizing tables to 5NF
- D) Defragmenting B-Trees

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Horizontal partitioning where data is split across multiple independent physical database servers / instances based on a shard key (e.g. `user_id % num_shards`)**
**Explanation:** Sharding allows relational databases to scale writes horizontally beyond the memory/CPU limits of a single machine.
</details>

---

### Q105. What is the Write-Ahead Log (WAL) or Redo Log?
- A) An append-only sequential log on disk where transaction changes are recorded BEFORE data pages are written to disk, ensuring Durability (Crash Recovery)
- B) Application log files
- C) User access history
- D) A backup file created daily

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) An append-only sequential log on disk where transaction changes are recorded BEFORE data pages are written to disk, ensuring Durability (Crash Recovery)**
**Explanation:** Sequential disk I/O to the WAL is orders of magnitude faster than random I/O updates to table B-trees. In the event of a power crash, the database replays the WAL to recover committed transactions.
</details>

---

## 🏆 Scoring & Proficiency Benchmark

| Score Range | Proficiency Level | Evaluation |
| :--- | :--- | :--- |
| **95 – 105** | 🌟 **Database Grandmaster / DBA** | In-depth mastery of query planners, SARGability, locking mechanisms, and analytical SQL. |
| **80 – 94** | 🚀 **Senior Backend / Data Engineer** | Strong command of window functions, execution order, complex joins, and index optimization. |
| **60 – 79** | 📈 **Intermediate SQL Developer** | Good foundation; review 3-valued NULL logic, window framing (`ROWS` vs `RANGE`), and subquery traps. |
| **Below 60** | 💡 **Learner / Junior** | Re-read the explanations, execute the queries in your database, and inspect execution plans! |

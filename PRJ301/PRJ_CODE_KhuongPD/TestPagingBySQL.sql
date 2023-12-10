--Phân trang SQL(Server 2 cách)

--C1: Dùng RowNumer
CREATE PROC Paging (
@PageIndex AS int,
@PageNum AS int
)
AS BEGIN
Declare @CurrentRow AS INT = (@PageIndex-1) * @PageNum
Declare @NextRow AS INT = @PageIndex * @PageNum
Declare @TotalRow AS INT = (SELECT COUNT(*) FROM Student)

select id, ROW_NUMBER() over (order by id) as RowNum Into #Temp from student

select *,@TotalRow totalRow From Student st
inner join #Temp Temp on st.Id=Temp.Id
where Temp.RowNum > @CurrentRow AND Temp.RowNum<=@NextRow

END
-- Testing
exec Paging 2,5

--C2: Dùng OFFSET..FETCH NEXT
CREATE PROC Paging2(
@PageIndex AS int,
@PageNum AS int
)
AS BEGIN
Declare @CurrentRow AS INT = (@PageIndex - 1) * @PageNum
Declare @TotalRow AS INT = (SELECT COUNT(*) FROM Student)

SELECT *, @TotalRow totalRow FROM Student
ORDER BY Id
OFFSET @CurrentRow ROWS
FETCH NEXT @PageNum ROWS ONLY 

END

-- Testing
exec Paging2 2,5
		<%@ include file="common/header.jspf" %>
	
		<%@ include file="common/navigation.jspf" %> 
	
		<div class="container">
			<H1> Your todos </H1>
	
				<table class="table">
					<thead>
						<tr>
					<!--		<th>Id</th>  -->
							<th>Description</th>
							<th>Target Date</th>
							<th>Is Done?</th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${todos}" var="todo">
						<tr>
						<!--	<td>${todo.id}</td>   -->
							<td>${todo.description}</td>
							<td>${todo.targetDate}</td>
							<td>${todo.isDone}</td>	
							<td><a href="update-todo?id=${todo.id}" class="btn btn-success"/>Update</a></td>
							<td><a href="delete-todo?id=${todo.id}" class="btn btn-success btn-danger"/>Delete</a></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				<a href="create-todo" class="btn btn-success"> Add todo </a>
		</div>
		<%@ include file="common/footer.jspf" %>

<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<div class="row">
		<c:if test="${not empty message}">
			<div class="col-xs-12">

				<div class="alert alert-success alert-dismissible">

					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${message}
				</div>
			</div>
		</c:if>

		<div class="col-md-offset-2 col-md-8">
			<div class="panel panel-primary">

				<div class="panel-heading">
					<h4>Product Management</h4>
				</div>
				<div class="panel-body">
					<!-- form elements -->

					<!-- name -->
					<sf:form class="form-horizontal" modelAttribute="product"
						action="${contextRoot}/manage/products" method="post"
						enctype="multipart/form-data">
						<div class="form-group">
							<label class="control-label col-md-4" for="name">Enter
								Product Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="name" id="name"
									placeholder="Product Name" class="form-control" />
								<sf:errors path="name" cssClass="help-block" element="em" />
							</div>
						</div>

						<!-- Brand -->
						<div class="form-group">
							<label class="control-label col-md-4" for="brand">Enter
								Brand Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="brand" id="brand"
									placeholder="Brand Name" class="form-control" />
								<sf:errors path="brand" cssClass="help-block" element="em" />
							</div>
						</div>

						<!-- Description -->
						<div class="form-group">
							<label class="control-label col-md-4">Description</label>
							<div class="col-md-8">
								<sf:textarea path="description" class="form-control"
									placeholder="Enter your description here!" />
								<sf:errors path="description" cssClass="help-block" element="em" />
							</div>
						</div>

						<!-- Unit Price -->
						<div class="form-group">
							<label class="control-label col-md-4" for="unitPrice">Unit
								Price</label>
							<div class="col-md-8">
								<sf:input type="number" path="unitPrice" id="unitPrice"
									placeholder="Unit Price In &#8377" class="form-control" />
								<sf:errors path="unitPrice" cssClass="help-block" element="em" />
							</div>
						</div>

						<!-- Quantity -->
						<div class="form-group">
							<label class="control-label col-md-4" for="quantity">Quantity
								Available</label>
							<div class="col-md-8">
								<sf:input type="number" path="quantity" id="quantity"
									placeholder="Quantity Available" class="form-control" />
							</div>
						</div>

						<!-- Image File upload  -->
						<div class="form-group">
							<label class="control-label col-md-4" for="file">Select
								Image</label>
							<div class="col-md-8">
								<sf:input type="file" path="file" id="file" class="form-control" />
								<sf:errors path="file" cssClass="help-block" element="em" />
							</div>
						</div>

						<!-- Category -->
						<div class="form-group">
							<label class="control-label col-md-4" for="categoryId">Select
								Category</label>
							<div class="col-md-8">
								<sf:select class="form-control" path="categoryId"
									id="categoryId" items="${categories}" itemLabel="name"
									itemValue="id" />
								<c:if test="${product.id==0}">
									<div class="text-right">
										<br />
										<button type="button" data-toggle="modal"
											data-target="#myCategoryModal" class="btn btn-warning btn-xm">Add
											Category</button>
									</div>
								</c:if>

							</div>
						</div>

						<!-- Submit Button -->
						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" name="submit" id="submit" value="Submit"
									class="btn btn-primary" />

								<!-- Hidden fields -->
								<sf:hidden path="id" />
								<sf:hidden path="code" />
								<sf:hidden path="supplierId" />
								<sf:hidden path="active" />
								<sf:hidden path="purchases" />
								<sf:hidden path="views" />
							</div>
						</div>

					</sf:form>
				</div>
			</div>

		</div>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<h3>Available Products</h3>
			<hr />
		</div>
		<div class="col-xs-12">
		<div class="container-fluid">
					<div class="table-responsive">
				<table id="adminProductsTable"
					class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>Id</th>
							<th>&#160;</th>
							<th>Name</th>
							<th>Brand</th>
							<th>Quantity Available</th>
							<th>Unit Price</th>
							<th>Activate</th>
							<th>Edit</th>
						</tr>
					</thead>

					<%-- <tbody>
				<tr>
				<td>38</td>
				<td>
				<img class="adminDataTableImg" src="${contextRoot}/resources/images/PRD401ACF27D5.jpg" alt="Naresh Product"/>
				</td>
				<td>Naresh Product</td>
				<td>Naresh Brand</td>
				<td>2</td>
				<td>&#8377;30000.00/-</td>
				<td>
					<!-- toggle switch -->
				<label class="switch">
				<input type="checkbox" checked="checked" value="38"/>
				<div class="slider"></div>
				</label>
				</td>
				<td>
				<a href="${contextRoot}/manage/2/product" class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span></a>
				</td>
				</tr>
				
				<tr>
				<td>38</td>
				<td>
				<img class="adminDataTableImg" src="${contextRoot}/resources/images/PRD401ACF27D5.jpg" alt="Naresh Product"/>
				</td>
				<td>Naresh Product</td>
				<td>Naresh Brand</td>
				<td>2</td>
				<td>&#8377;30000.00/-</td>
				<td>
					<!-- toggle switch -->
				<label class="switch">
				<input type="checkbox"  value="38"/>
				<div class="slider"></div>
				</label>
				</td>
				<td>
				<a href="${contextRoot}/manage/2/product" class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span></a>
				</td>
				</tr>
				</tbody> --%>

					<tfoot>
						<tr>
							<th>Id</th>
							<th>&#160;</th>
							<th>Name</th>
							<th>Brand</th>
							<th>Quantity Available</th>
							<th>Unit Price</th>
							<th>Activate</th>
							<th>Edit</th>
						</tr>
					</tfoot>


				</table>
			
</div>
</div>

		</div>
	</div>

	<div class="modal fade" id="myCategoryModal" role="dialog"
		tabindex="-1">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<!-- modal header -->
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span>&times;</span>
					</button>
					<h4 class="modal-title">Add New Category</h4>
				</div>
				<div class="modal-body">
					<!-- category form -->
					<sf:form id="categoryForm" modelAttribute="category" action="${contextRoot}/manage/category" method="post" class="form-horizontal">
						
						<div class="form-group">
							<label for="category_name" class="control-label col-md-4">Category Name</label>
							<div class="col-md-8">
								<sf:input path="name" type="text" id="category_name" class="form-control" />
							</div>
						</div>
						
						<div class="form-group">
							<label for="category_description" class="control-label col-md-4">Category Description</label>
							<div class="col-md-8">
								<sf:textarea path="description" cols="" rows="5" id="category_description" class="form-control" />
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
							<input type="submit" value="Add Category" class="btn btn-primary"/>
							</div>
						</div>
						
					</sf:form>
				</div>
			</div>
		</div>
	</div>
</div>
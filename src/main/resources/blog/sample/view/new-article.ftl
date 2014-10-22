<#-- @ftlvariable name="" type="blog.sample.view.ArticleView" -->
<#import "layout.ftl" as layout>
<@layout.mainLayout>

<script type="text/javascript">
    //<![CDATA[
    $(document).ready(function () {
        $('#save').click(function () {
            var articleid = '';
            $.ajax({
                url: '/blog/article/save',
                type: 'POST',
                data: JSON.stringify($('#articleForm').serializeJSON()),
                contentType: 'application/json; charset=utf-8',
                dataType: 'text',
                success: function (response) {
                    articleid = response;
                    alert("Save Successfully");
                    // View article
                    window.location.replace("/blog/article/view/" + response);
                },
                error: function (response) {
                    alert("Error Occurred: " + response);
                }
            });
        });
    });
    //]]>
</script>

<div class="row">
    <!-- Blog Post Content Column -->
    <div class="col-lg-8">
        <!-- Blog Post -->
        <form id="articleForm" name="articleForm" role="form">
            <!-- Form Name -->
            <legend>Blog Post</legend>

            <!-- Headline -->
            <div class="form-group">
                <label for="headline">Headline</label>
                <input type="text" class="form-control" id="headline" name="headline"
                       placeholder="Headline here">
            </div>

            <!-- Blog post -->
            <div class="form-group">
                <label for="body">Post</label>
                <textarea class="form-control" id="body" name="body" rows="10"
                          placeholder="Blog post content here"></textarea>
            </div>

            <!-- Author -->
            <div class="form-group">
                <label for="headline">Author</label>
                <input type="text" class="form-control" id="author" name="author"
                       placeholder="Author name here">
            </div>

            <!-- Save -->
            <button id="save" name="save" class="btn btn-info" type="button">Save</button>
        </form>
        <hr>
    </div>
    <!-- Blog Sidebar Widgets Column -->
    <div class="col-md-4">
        <!-- Blog Search Well -->
        <div class="well">
            <h4>Blog Search</h4>

            <div class="input-group">
                <input type="text" class="form-control">
<span class="input-group-btn">
<button class="btn btn-default" type="button">
    <span class="glyphicon glyphicon-search"></span>
</button>
</span>
            </div>
            <!-- /.input-group -->
        </div>
        <!-- Blog Categories Well -->
        <div class="well">
            <h4>Blog Categories</h4>

            <div class="row">
                <div class="col-lg-6">
                    <ul class="list-unstyled">
                        <li><a href="#">Category Name</a>
                        </li>
                        <li><a href="#">Category Name</a>
                        </li>
                        <li><a href="#">Category Name</a>
                        </li>
                        <li><a href="#">Category Name</a>
                        </li>
                    </ul>
                </div>
                <div class="col-lg-6">
                    <ul class="list-unstyled">
                        <li><a href="#">Category Name</a>
                        </li>
                        <li><a href="#">Category Name</a>
                        </li>
                        <li><a href="#">Category Name</a>
                        </li>
                        <li><a href="#">Category Name</a>
                        </li>
                    </ul>
                </div>
            </div>
            <!-- /.row -->
        </div>
    </div>
</div>
<!-- /.row -->
<hr>
<!-- Footer -->
<footer>
    <div class="row">
        <div class="col-lg-12">
            <p>Copyright &copy; Blog Website 2014</p>
        </div>
    </div>
    <!-- /.row -->
</footer>
</@layout.mainLayout>
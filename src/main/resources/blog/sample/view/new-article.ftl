<#-- @ftlvariable name="" type="blog.sample.view.ArticleView" -->
<#import "layout.ftl" as layout>
<@layout.mainLayout>

<div class="row">
    <!-- Blog Post Content Column -->
    <div class="col-lg-8">
        <!-- Blog Post -->
        <form class="form-horizontal" method="post" action="/blog/article/save">
            <fieldset>
                <!-- Form Name -->
                <legend>Blog Post</legend>

                <!-- Text input-->
                <div class="control-group">
                    <label class="control-label" for="textinput">Headline</label>
                    <div class="controls">
                        <input id="headline" name="headline" placeholder="blog post headline here" class="input-xlarge" required="" type="text"
                                value="${article.headline}">

                    </div>
                </div>

                <!-- Textarea -->
                <div class="control-group">
                    <label class="control-label" for="textarea">Post</label>
                    <div class="controls">
                        <textarea id="body" name="body" content="${article.body}"></textarea>
                    </div>
                </div>

                <!-- Button (Double) -->
                <div class="control-group">
                    <label class="control-label" for="button1"></label>
                    <div class="controls">
                        <button id="save" name="save" class="btn btn-info" type="submit">Save</button>
                        <button id="reset" name="reset" class="btn btn-danger" type="reset">Reset</button>
                    </div>
                </div>

            </fieldset>
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
        <!-- Side Widget Well -->
        <div class="well">
            <h4>Side Widget Well</h4>

            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore, perspiciatis adipisci accusamus
                laudantium odit aliquam repellat tempore quos aspernatur vero.</p>
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
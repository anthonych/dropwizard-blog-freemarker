<#import "layout.ftl" as layout>

<@layout.mainLayout>

<div class="row">
    <div class="col-md-8">
        <h1 class="page-header">
            Articles
            <small></small>
        </h1>

        <#list articles as article>
            <h2>
                <a href="/blog/article/view/${article.id}">${article.headline}</a>
            </h2>

            <p class="lead">
                by <a href="">${article.author}</a>
            </p>

            <p><span class="glyphicon glyphicon-time"></span> Posted on ${article.postDate}</p>
            <hr>
            <p>
            ${article.body}
            </p>
            <a class="btn btn-primary" href="/blog/article/view/${article.id}">Read More <span
                    class="glyphicon glyphicon-chevron-right"></span></a>

            <hr>
        </#list>
        <!-- Pager -->
        <!--
        <ul class="pager">
            <li class="previous">
                <a href="#">&larr; Older</a>
                </li>
                <li class="next">
                    <a href="#">Newer &rarr;</a>
                </li>
            </ul>
            -->
    </div>
    <!-- Blog Sidebar Widgets Column -->
    <!--
    <div class="col-md-4">
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
        </div>
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
        </div>
    </div>
    -->
</div>
</@layout.mainLayout>
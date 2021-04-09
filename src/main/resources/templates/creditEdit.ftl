<#import "parts/common.ftl" as c>
<@c.page>
<#list credits as credit>
<div class="form-group mt-3">
            <form method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="text" class="form-control" name="name" placeholder="Name of credit" value = "${credit.creditName}" />
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="limit" placeholder="Limit" value = "${credit.limit}">
                </div>
                <div class="form-group">
                     <input type="text" class="form-control" name="percent" placeholder="Percent" value = "${credit.percent}">
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Edit</button>
                </div>
                <div class="form-group">
                <a href="/creditDelete/${credit.creditUUID}" button type="submit" class="btn btn-primary">Delete</button></a>
                </div>
            </form>
        </div>
<#else>
No such credit!
</#list>
</@c.page>
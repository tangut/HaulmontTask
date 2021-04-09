<#import "parts/common.ftl" as c>
<@c.page>
<#list credits as credit>
Are you sure you want to delete this credit?
<div class="card my-3">
     <div class="m-2">
    <br><span>Name: ${credit.creditName}</span>
    <br><span>Limit: ${credit.limit}</span>
    <br><span>Percent: ${credit.percent}</span>
    </div>
</div>
<div class="form-group mt-3">
            <form method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <class="form-control" name="name" placeholder="Name of credit" value = "${credit.creditName}" />
                </div>
                <div class="form-group">
                    <class="form-control" name="limit" placeholder="Limit" value = "${credit.limit}">
                </div>
                <div class="form-group">
                     <class="form-control" name="percent" placeholder="Percent" value = "${credit.percent}">
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Delete</button>
                </div>
            </form>
        </div>
<#else>
No such credit!
</#list>
</@c.page>
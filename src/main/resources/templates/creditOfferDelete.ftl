<#import "parts/common.ftl" as c>
<@c.page>
<#list creditOffers as credit>
<div class="form-group mt-3">
            <form method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="text" class="form-control" name="nameClient" placeholder="Name of client" value = "${credit.client.name}" />
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="nameCredit" placeholder="Name of Credit" value = "${credit.credit.creditName}">
                </div>
                <div class="form-group">
                     <input type="text" class="form-control" name="summCredit" placeholder="Sum of credit" value = "${credit.summCredit}">
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Edit</button>
                </div>
                <div class="form-group">
                <a href="/creditOfferDelete/${credit.offerUUID}" button type="submit" class="btn btn-primary">Delete</button></a>
                </div>
            </form>
        </div>
<#else>
No such credit offer!
</#list>
</@c.page>
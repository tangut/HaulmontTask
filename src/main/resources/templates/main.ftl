<#import "parts/common.ftl" as c>
<@c.page>
<div class="card-columns">
<#list clients as client>
<div class="card my-3">
     <div class="m-2">
    <br><span>Name: ${client.name}</span>
    <br><span>Phone: ${client.phoneNumber}</span>
    <br><span>Mail: ${client.email}</span>
    <br><strong> Passport: ${client.passportNumber}</strong>
    </div>
</div>
<#else>
No clients yet
</#list>
</div>
</@c.page>
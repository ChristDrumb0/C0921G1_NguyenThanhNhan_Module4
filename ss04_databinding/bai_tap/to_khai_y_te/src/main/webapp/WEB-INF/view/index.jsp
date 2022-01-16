<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Choose Condiment </title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row" id="title">
        <%--        Thông báo--%>
        <c:if test="${medicalDeclaration == null}">
            <h4>Bạn chưa khai báo y tế!</h4>
            <button class="bg-primary"><a href="/medical_declaration" style="color: white">Khai báo ngay</a></button>
        </c:if>
        <%--Thong bao: success/--%>
        <c:if test="${message != null}">
            <p style="color: red">${message}</p>
        </c:if>

    </div>
    <c:if test="${info != null}">

        <%--    /body:--%>
    <div class="row mt-5" style="display: block">
            <%--            HỌ tên (Ghi chữ IN HOA) --%>
        <div class="form-group">
            <label>HỌ tên</label>
            <input type="text" value="${info.fullName}" class="form-control" readonly="true"/>
        </div>

            <%--            Năm sinh -giới tính - quốc tịch--%>
        <div class="form-row">
            <div class="form-group col-md-4">
                <label>Năm sinh</label>
                <input value="${info.yearOfBirth}" class="form-control" readonly="true"/>
            </div>
            <div class="form-group col-md-4">
                <label>Giới tính</label>
                <input value="${info.gender}" class="form-control" readonly="true"/>
            </div>
            <div class="form-group col-md-4">
                <label>Quốc Tịch</label>
                <input value="${info.nationality}" class="form-control" readonly="true"/>
            </div>
        </div>
            <%--           số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác--%>
        <div class="form-group">
            <label>Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác</label>
            <input value="${info.idCard}" class="form-control" readonly="true"/>
        </div>
            <%--           Thông tin đi lại: radiobuttons--%>
        <div class="form-check form-check-inline" style="display: block">
            <label>Thông tin đi lại </label>
            <input value="${info.transportation}" readonly="true"/>
        </div>
            <%--           Số hiệu phương tiện - Số ghế--%>

        <div class="form-row">
            <div class="form-group col-md-6">
                <label>Số hiệu phương tiện</label>
                <input value="${info.transportNumber}" class="form-control" readonly="true"/>
            </div>

            <div class="form-group col-md-6">
                <label>Số ghế</label>
                <input value="${info.seatNumber}" class="form-control" readonly="true"/>
            </div>
        </div>

            <%--           Ngày khởi hành - Ngày kết thúc--%>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label>Ngày khởi hành</label>
                <input value="${info.departureDay}" class="form-control" readonly="true"/>
            </div>

            <div class="form-group col-md-6">
                <label>Ngày kết thúc</label>
                <input value="${info.endDate}" class="form-control" readonly="true"/>
            </div>
        </div>

            <%--           Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào?--%>
        <div class="form-group">
            <label>Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố :</label>
            <input value="${info.visitedLocation}" class="form-control" readonly="true"/>
        </div>

            <%--           Địa chỉ liên lạc : Tỉnh/thành   -  Quận/huyện  - Phường-xã --%>

        <div class="form-row">
            <label class="col-md-12">Địa chỉ liên lạc</label>
            <div class="form-group col-md-4">
                <label>Tỉnh/thành</label>
                <input value="${info.province}" class="form-control" readonly="true"/>
            </div>
            <div class="form-group col-md-4">
                <label>Quận/huyện</label>
                <input value="${info.district}" class="form-control" readonly="true"/>
            </div>
            <div class="form-group col-md-4">
                <label>Phường-xã</label>
                <input value="${info.ward}" class="form-control" readonly="true"/>
            </div>
        </div>

            <%--           Địa chỉ nơi ở --%>

        <div class="form-group">
            <label>Địa chỉ nơi ở</label>
            <input value="${info.address}" class="form-control" readonly="true"/>
        </div>

            <%--           Điện thoại  - Email --%>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label>Điện thoại</label>
                <input value="${info.phone}" class="form-control" readonly="true"/>
            </div>

            <div class="form-group col-md-6">
                <label>Email</label>
                <input value="${info.email}" class="form-control" readonly="true"/>
            </div>
        </div>

            <%--            Triệu chứng--%>
        <div class="form-check form-check-inline" style="display: block">
            <label>Trong vòng 14 ngày qua, Anh chị có xuất hiện triệu chứng : </label>
            <c:forEach items="${info.symptoms}" var="item">
                <span>${item}</span>
            </c:forEach>
        </div>

            <%--           Lịch sử phơi nhiễm--%>
        <div class="form-check form-check-inline" style="display: block">
            <label class="col-md-12">Lịch sử phơi nhiễm: Trong vòng 14 ngày qua, Anh chị có</label>
            <c:if test='${(info.historyExposure).equals("")}'>
                Không
            </c:if>
            <c:if test='${!(info.historyExposure).equals("")}'>
                <c:forEach items="${info.historyExposure}" var="item">
                    <span>${item}</span>
                </c:forEach>
            </c:if>

        </div>

        <div class="col-md-12 mt-5">
            <h6 STYLE="color: red">Dữ liệu bạn cung cấp hoàn toàn bảo mật và chỉ phục vụ cho công tác phòng chống
                dịch </h6>
        </div>

        </c:if>
    </div>
</div>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
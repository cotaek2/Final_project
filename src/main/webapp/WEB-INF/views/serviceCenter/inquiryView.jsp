<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
    <title>문의 상세</title>
    
    <!-- nav, footer CSS -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/fontawesome.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/templatemo-villa-agency.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/owl.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/animate.css">
    <link rel="stylesheet"href="https://unpkg.com/swiper@7/swiper-bundle.min.css"/>
    
    
    <!-- content CSS, JS -->
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/core.css" class="template-customizer-core-css" />
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/theme-default.css" class="template-customizer-theme-css" />
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/demo.css" />
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/perfect-scrollbar.css" />
    <script src="<%=request.getContextPath() %>/resources/js/helpers.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/config.js"></script>
  
  </head>
<body>
	<%@ include file="../include/nav/userNav.jsp"%>
	<div class="layout-wrapper layout-content-navbar">
		<div class="layout-container">
			<%@ include file="../include/nav/userBoardNav.jsp"%>
			<!-- 본문 컨테이너 -->
			<div class="layout-page">

				<!-- Content wrapper -->
				<div class="content-wrapper">
					<!-- 본문 시작 -->
					<div class="container-xxl flex-grow-1 container-p-y">

						<h4 class="fw-bold py-3 mb-4">문의 게시판</h4>
						
						<!-- Basic Bootstrap Table -->
						<div class="row h-50">
							<div class="card">
								<div class="table-responsive text-nowrap">
									<table class="table">
										<thead>
											<tr>
												<th>샘플 제목입니다.</th>
												<th class="right">2024.03.13</th>
											</tr>
										</thead>
										<tbody class="table-border-bottom-0 ">
											<tr>
												<td colspan=2>본문입니다.</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<!--/ Basic Bootstrap Table -->
						
						<a href="inquiryList"><button class="right btn btn-primary mt-3">목록으로</button></a>
						<a href="inquiryModify"><button class="btn btn-primary mt-3 ">수정</button></a>

						<div style="margin-top:100px" class="row">
							<div class="table-responsive text-nowrap">
								<table class="table">
									<thead>
									</thead>
									<tbody>
										<tr>
											<td><a>다음글 ▲ </a><span> 샘플 제목입니다.</span></td>
										</tr>
										<tr>
											<td><a>이전글 ▼ </a><span> 샘플 제목입니다.</span></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>


							<h6 class="mt-2 mb-3 text-muted">관리자 답변</h6>
							<div
								class="navbar navbar-example navbar-expand-lg bg-light">
								<div class="container-fluid"><b>답변 샘플 본문입니다</b></div>
							</div>
							
						<!-- 본문 끝 -->
						<%@ include file="../include/footer/adminFooter.jsp"%>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	

</body>
</html>
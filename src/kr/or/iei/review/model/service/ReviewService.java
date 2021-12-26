package kr.or.iei.review.model.service;

import java.util.HashMap;

import kr.or.iei.review.model.vo.Review;
import kr.or.iei.review.model.vo.ReviewComment;

public interface ReviewService {

	/**
	 * 작성자: 이형우
	 * 
	 * 작성일: 2021-12-23
	 *
	 * Description : 일반 리뷰의 페이징을 8개로 주고 DB에서 가져오는 메소드 (요정한 목록을 리턴함)
	 */
	
	HashMap<String, Object> selectAllPostList(int currentPage);

	Review selectOnePost(int postNum);

	int insertBoardComment(ReviewComment co);

	int updateReviewComment(ReviewComment co);

	int deleteReviewComment(int r_c_no, String userId);

	int insertPostWrite(Review review);

	int searchReviewNo(Review review);

	
}

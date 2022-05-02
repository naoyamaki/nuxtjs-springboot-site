package com.example.infrastructure.repository;

import com.example.domain.model.PublishReviewEntity;
import com.example.domain.model.UserEntity;
import com.example.domain.repository.PublishReviewRepository;
import com.example.infrastructure.jooq.tables.records.ReviewRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static com.example.infrastructure.jooq.Tables.REVIEW;
import static com.example.infrastructure.jooq.Tables.USER;

@Repository
public class PublishReviewRepositoryImpl implements PublishReviewRepository {
    private final Integer PUBLISH_STATUS = 1;
    private final Integer PENDING_STATUS = 2;

    String url = "jdbc:mysql://db:3306/main?useUnicode=true&characterEncoding=utf8&connectionTimeZone=SERVER&enabledTLSProtocols=TLSv1.2";
    String userName = "root";
    String password = "password1234";

    Connection connection = null;

    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, userName, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    DSLContext create = DSL.using(connection, SQLDialect.MYSQL);

    public ArrayList<PublishReviewEntity> getByPage(Integer offset, Integer limit) {
        Select<Record7<Integer, Integer, String, String, Integer, LocalDateTime, LocalDateTime>> records =
                create.select(
                        REVIEW.ID
                        ,REVIEW.USER_ID
                        ,REVIEW.TITLE
                        ,REVIEW.BODY
                        ,REVIEW.CATEGORY_ID
                        ,REVIEW.INSERT_DATE
                        ,REVIEW.UPDATE_DATE
                )
                .from(REVIEW)
                .where(REVIEW.STATUS.equal(PUBLISH_STATUS))
                .orderBy(REVIEW.ID).limit(limit).offset(offset);

        if (records.stream().count() == 0) {
            // TODO: エラーを返す
            return null;
        }

        ArrayList<PublishReviewEntity> publicReviewList = new ArrayList<>();
        for (Record7 record: records) {
            PublishReviewEntity publishReview = new PublishReviewEntity(
                    record.getValue(REVIEW.ID)
                    , record.getValue(REVIEW.USER_ID)
                    , record.getValue(REVIEW.TITLE)
                    , record.getValue(REVIEW.BODY)
                    , record.getValue(REVIEW.CATEGORY_ID)
                    , record.getValue(REVIEW.INSERT_DATE)
                    , record.getValue(REVIEW.UPDATE_DATE)
            );
            publicReviewList.add(publishReview);
        }
        return publicReviewList;
    }

    public ArrayList<PublishReviewEntity> searchByUserId(Integer userId, Integer offset, Integer limit) {
        Select<Record7<Integer, Integer, String, String, Integer, LocalDateTime, LocalDateTime>> records =
                create.select(
                                REVIEW.ID
                                ,REVIEW.USER_ID
                                ,REVIEW.TITLE
                                ,REVIEW.BODY
                                ,REVIEW.CATEGORY_ID
                                ,REVIEW.INSERT_DATE
                                ,REVIEW.UPDATE_DATE
                        )
                        .from(REVIEW)
                        .where(REVIEW.STATUS.equal(PUBLISH_STATUS))
                        .and(REVIEW.USER_ID.equal(userId))
                        .orderBy(REVIEW.ID).limit(limit).offset(offset);

        if (records.stream().count() == 0) {
            // TODO: エラーを返す
            return null;
        }

        ArrayList<PublishReviewEntity> publicReviewList = new ArrayList<>();
        for (Record7 record: records) {
            PublishReviewEntity publishReview = new PublishReviewEntity(
                    record.getValue(REVIEW.ID)
                    , record.getValue(REVIEW.USER_ID)
                    , record.getValue(REVIEW.TITLE)
                    , record.getValue(REVIEW.BODY)
                    , record.getValue(REVIEW.CATEGORY_ID)
                    , record.getValue(REVIEW.INSERT_DATE)
                    , record.getValue(REVIEW.UPDATE_DATE)
            );
            publicReviewList.add(publishReview);
        }
        return publicReviewList;
    }

    /*
    public PublishReviewEntity searchByKeyword(String[] query, Integer offset, Integer limit) {
        ReviewRecord record = create
                .select(
                        REVIEW.ID
                        ,REVIEW.USER_ID
                        ,REVIEW.TITLE
                        ,REVIEW.BODY
                        ,REVIEW.CATEGORY_ID
                        ,REVIEW.INSERT_DATE
                        ,REVIEW.UPDATE_DATE
                )
                .from(REVIEW)
                .where(REVIEW.STATUS.equal(1))
                .orderBy(REVIEW.ID).limit(limit).offset(offset)
                .fetchOneInto(ReviewRecord.class);
        PublishReviewEntity review = new PublishReviewEntity(
                record.getId()
                , record.getUserId()
                , record.getTitle()
                , record.getBody()
                , record.getCategoryId()
                , record.getInsertDate()
                , record.getUpdateDate());
        return review;
    }
     */
}

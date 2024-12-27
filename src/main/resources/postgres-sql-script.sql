drop table if exists cloud.quiz_questions cascade;
drop table if exists cloud.quizzes cascade;
drop table if exists cloud.question_pool cascade;
drop table if exists cloud.authorize_mapping cascade;
drop type if exists cloud.question_type cascade;
drop type if exists cloud.exam_code cascade;
drop type if exists cloud.provider cascade;
drop schema if exists cloud cascade;

create schema if not exists cloud;
create type cloud.exam_code as enum('CLOUD_PRACTITIONER', 'DEVELOPER_ASSOCIATE', 'SOLUTIONS_ARCHITECT');
create type cloud.provider as enum('AWS', 'GCP', 'AZURE');

create table cloud.authorize_mapping(
	"cloud_provider" cloud.provider not null,
	"exam_code" cloud.exam_code not null,
	max_questions int8 not null,
	primary key("cloud_provider", "exam_code")
);

create table if not exists cloud.question_pool(
	 num serial8 primary key,
	 "cloud_provider" cloud.provider not null,
	 "exam_code" cloud.exam_code not null,
	 question text not null,
	 options_list text[] not null,
	 is_multi_option boolean not null default false,
	 answer text not null,
	 explanation text,
	 foreign key("cloud_provider", "exam_code") references cloud.authorize_mapping("cloud_provider", "exam_code")
);

create table if not exists cloud.quizzes (
	id serial8 primary key,
	title text not null,
	created_at timestamp default NOW()
);
create table if not exists cloud.quiz_questions (
	quiz_id int8 not null references cloud.quizzes(id) on delete cascade,
	question_num int8 not null references cloud.question_pool(num) on delete cascade,
	unique (quiz_id, question_num)
);

insert into cloud.authorize_mapping (cloud_provider, exam_code, max_questions) values('AWS', 'CLOUD_PRACTITIONER', 65);

insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, "exam_code", "cloud_provider", options_list, answer) values('AWS Elastic Beanstalk is a service that manages web infrastructure.', 'CLOUD_PRACTITIONER', 'AWS', '{"True", "False"}', 'True');
insert into cloud.question_pool (question, exam_code, cloud_provider, options_list, answer) values ('What is AWS?', 'CLOUD_PRACTITIONER', 'AWS', '{"Amazon web services", "Amazon Web Shopping", "America Web Services"}', 'Amazon web services');

select * from cloud.question_pool;

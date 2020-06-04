# 网站基本信息
DROP TABLE IF EXISTS `oj_website_config`;
CREATE TABLE `oj_website_config` (
    `website_name` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
INSERT INTO `oj_website_config` (`website_name`) VALUES
('Online Judge');
# 公告表
DROP TABLE IF EXISTS `announcements`;
CREATE TABLE `announcements` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `title` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL,
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `create_by` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'root',
    `content` text COLLATE utf8mb4_unicode_ci NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
INSERT INTO `announcements` (`title`, `content`) VALUES
('测试1', '测试内容1'),
('测试2', '测试内容2'),
('测试3', '测试内容3'),
('测试4', '测试内容4'),
('测试5', '测试内容5'),
('测试6', '测试内容6'),
('测试7', '测试内容7'),
('测试8', '测试内容8'),
('测试9', '测试内容9'),
('测试10', '测试内容10'),
('测试11', '测试内容11'),
('测试12', '测试内容12'),
('测试13', '测试内容13'),
('测试14', '测试内容14'),
('测试15', '测试内容15'),
('测试16', '测试内容16'),
('测试17', '测试内容17'),
('测试18', '测试内容18'),
('测试19', '测试内容19'),
('测试20', '测试内容20'),
('测试21', '测试内容21'),
('测试22', '测试内容22'),
('测试23', '测试内容23'),
('测试24', '测试内容24'),
('测试25', '测试内容25'),
('测试26', '测试内容26'),
('测试27', '测试内容27'),
('测试28', '测试内容28'),
('测试29', '测试内容29'),
('测试30', '测试内容30'),
('测试31', '测试内容31');

# 题目数据表
DROP TABLE IF EXISTS `oj_problems`;
CREATE TABLE `oj_problems` (
    `problem_id` bigint(20) NOT NULL,
    `problem_title` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL,
    `problem_description` text COLLATE utf8mb4_unicode_ci NOT NULL,
    `problem_input_description` text COLLATE utf8mb4_unicode_ci NOT NULL,
    `problem_output_description` text COLLATE utf8mb4_unicode_ci NOT NULL,
    /* [{"input": "test1", "output": "123"}, {"input": "test2", "output": "456"}] */
    `problem_samples` text COLLATE utf8mb4_unicode_ci NOT NULL,
    /* [{"input_name": "1.in", "output_name": "1.out", "score": 40}, {"input_name": "2.in", "output_name": "2.out", "score": 60}] */
    `problem_testcase_score` text COLLATE utf8mb4_unicode_ci NOT NULL,
    `problem_hint` text COLLATE utf8mb4_unicode_ci NULL,
    `problem_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `problem_last_update` timestamp NOT NULL DEFAULT  CURRENT_TIMESTAMP,
    /* TO CHANGE: foreign key */
    `problem_create_by` varchar(128) NOT NULL DEFAULT 'root',
    /* ms */
    `problem_time_limit` int(8) NOT NULL,
    /* MB */
    `problem_memory_limit` int(8) NOT NULL,
    `problem_ac` bigint(20) NOT NULL DEFAULT 0,
    `problem_wa` bigint(20) NOT NULL DEFAULT 0,
    `problem_testcaseId` varchar(128) NOT NULL DEFAULT '',
    PRIMARY KEY(`problem_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO oj_problems
(`problem_id`, `problem_title`, `problem_description`, `problem_input_description`,
 `problem_output_description`, `problem_samples`, `problem_testcase_score`,
 `problem_create_by`, `problem_time_limit`, `problem_memory_limit`) VALUES
(1000, 'A + B Problem', '请计算两个整数的和并输出结果\r\n请注意不要有不必要的输出。示例代码见隐藏部分', '两个用空格分开的整数',
'两数之和', '[{"input": "1 1", "output": "2"}, {"input": "2 2", "output": "4"}]', '[{"inputName": "1.in", "outputName": "1.out", "score": 40}, {"inputName": "2.in", "outputName": "2.out", "score": 60}]',
 'root', '1000', '32'),
(1001, 'A + B Problem', '请计算两个整数的和并输出结果\r\n请注意不要有不必要的输出。示例代码见隐藏部分', '两个用空格分开的整数',
    '两数之和', '[{"input": "1 1", "output": "2"}, {"input": "2 2", "output": "4"}]', '[{"inputName": "1.in", "outputName": "1.out", "score": 40}, {"inputName": "2.in", "outputName": "2.out", "score": 60}]',
    'root', '1000', '32'),
(1002, 'A + B Problem', '请计算两个整数的和并输出结果\r\n请注意不要有不必要的输出。示例代码见隐藏部分', '两个用空格分开的整数',
    '两数之和', '[{"input": "1 1", "output": "2"}, {"input": "2 2", "output": "4"}]', '[{"inputName": "1.in", "outputName": "1.out", "score": 40}, {"inputName": "2.in", "outputName": "2.out", "score": 60}]',
    'root', '1000', '32'),
(1003, 'A + B Problem', '请计算两个整数的和并输出结果\r\n请注意不要有不必要的输出。示例代码见隐藏部分', '两个用空格分开的整数',
 '两数之和', '[{"input": "1 1", "output": "2"}, {"input": "2 2", "output": "4"}]', '[{"inputName": "1.in", "outputName": "1.out", "score": 40}, {"inputName": "2.in", "outputName": "2.out", "score": 60}]',
 'root', '1000', '32'),
(1004, 'A + B Problem', '请计算两个整数的和并输出结果\r\n请注意不要有不必要的输出。示例代码见隐藏部分', '两个用空格分开的整数',
 '两数之和', '[{"input": "1 1", "output": "2"}, {"input": "2 2", "output": "4"}]', '[{"inputName": "1.in", "outputName": "1.out", "score": 40}, {"inputName": "2.in", "outputName": "2.out", "score": 60}]',
 'root', '1000', '32'),
(1005, 'A + B Problem', '请计算两个整数的和并输出结果\r\n请注意不要有不必要的输出。示例代码见隐藏部分', '两个用空格分开的整数',
 '两数之和', '[{"input": "1 1", "output": "2"}, {"input": "2 2", "output": "4"}]', '[{"inputName": "1.in", "outputName": "1.out", "score": 40}, {"inputName": "2.in", "outputName": "2.out", "score": 60}]',
 'root', '1000', '32'),
(1006, 'A + B Problem', '请计算两个整数的和并输出结果\r\n请注意不要有不必要的输出。示例代码见隐藏部分', '两个用空格分开的整数',
 '两数之和', '[{"input": "1 1", "output": "2"}, {"input": "2 2", "output": "4"}]', '[{"inputName": "1.in", "outputName": "1.out", "score": 40}, {"inputName": "2.in", "outputName": "2.out", "score": 60}]',
 'root', '1000', '32'),
(1007, 'A + B Problem', '请计算两个整数的和并输出结果\r\n请注意不要有不必要的输出。示例代码见隐藏部分', '两个用空格分开的整数',
 '两数之和', '[{"input": "1 1", "output": "2"}, {"input": "2 2", "output": "4"}]', '[{"inputName": "1.in", "outputName": "1.out", "score": 40}, {"inputName": "2.in", "outputName": "2.out", "score": 60}]',
 'root', '1000', '32'),
(1008, 'A + B Problem', '请计算两个整数的和并输出结果\r\n请注意不要有不必要的输出。示例代码见隐藏部分', '两个用空格分开的整数',
 '两数之和', '[{"input": "1 1", "output": "2"}, {"input": "2 2", "output": "4"}]', '[{"inputName": "1.in", "outputName": "1.out", "score": 40}, {"inputName": "2.in", "outputName": "2.out", "score": 60}]',
 'root', '1000', '32'),
(1009, 'A + B Problem', '请计算两个整数的和并输出结果\r\n请注意不要有不必要的输出。示例代码见隐藏部分', '两个用空格分开的整数',
 '两数之和', '[{"input": "1 1", "output": "2"}, {"input": "2 2", "output": "4"}]', '[{"inputName": "1.in", "outputName": "1.out", "score": 40}, {"inputName": "2.in", "outputName": "2.out", "score": 60}]',
 'root', '1000', '32'),
(1014, 'A + B Problem', '请计算两个整数的和并输出结果\r\n请注意不要有不必要的输出。示例代码见隐藏部分', '两个用空格分开的整数',
 '两数之和', '[{"input": "1 1", "output": "2"}, {"input": "2 2", "output": "4"}]', '[{"inputName": "1.in", "outputName": "1.out", "score": 40}, {"inputName": "2.in", "outputName": "2.out", "score": 60}]',
 'root', '1000', '32'),
(1024, 'C + D Problem', '请计算两个整数的和并输出结果\r\n请注意不要有不必要的输出。示例代码见隐藏部分', '两个用空格分开的整数',
 '两数之和', '[{"input": "1 1", "output": "2"}, {"input": "2 2", "output": "4"}]', '[{"inputName": "1.in", "outputName": "1.out", "score": 40}, {"inputName": "2.in", "outputName": "2.out", "score": 60}]',
 'root', '1000', '32');
# 测试点数据表
DROP TABLE IF EXISTS `oj_problem_checkpoints`;
CREATE TABLE `oj_problem_checkpoints` (
    `problem_id` bigint(20) NOT NULL,
    `checkpoint_id` int(4) NOT NULL,
    `checkpoint_score` int(4) NOT NULL,
    `checkpoint_input` text COLLATE utf8mb4_unicode_ci NOT NULL,
    `checkpoint_output` text COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `oj_problem_checkpoints` (`problem_id`, `checkpoint_id`, `checkpoint_score`, `checkpoint_input`, `checkpoint_output`) VALUES
(1000, 0, 20, '1 1', '2'),
(1000, 1, 20, '1 1', '2'),
(1000, 2, 20, '1 1', '2'),
(1000, 3, 20, '1 1', '2'),
(1000, 4, 20, '1 1', '2');

DROP TABLE IF EXISTS `oj_submissions`;
CREATE TABLE `oj_submissions` (
    `submission_id` bigint(20) NOT NULL AUTO_INCREMENT,
    `problem_id` bigint(20) NOT NULL,
    `uid` bigint(20) NOT NULL,
    `submission_submit_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `submission_execute_time` timestamp NULL DEFAULT NULL,
    `submission_used_time` int(8) DEFAULT NULL,
    `submission_used_memory` int(8) DEFAULT NULL,
    `submission_judge_result` varchar(8) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'PD',
    `submission_judge_score` int(4) DEFAULT NULL,
    `submission_judge_log` text COLLATE utf8mb4_unicode_ci,
    `submission_code` text COLLATE utf8mb4_unicode_ci NOT NULL,
    PRIMARY KEY(`submission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
ALTER TABLE `oj_submissions` AUTO_INCREMENT = 100;
INSERT INTO `oj_submissions` (`problem_id`, `uid`, `submission_submit_time`, `submission_execute_time`, `submission_used_time`, `submission_used_memory`, `submission_judge_result`, `submission_judge_score`, `submission_judge_log`, `submission_code`) VALUES
(1000, 0, '2020-04-10 00:00:00', '2020-04-10 00:00:05', 30, 300, 'AC', 100, 'Wrong Answer.\r\n', '#include <iostream>\r\n\r\nint main() {\r\n    int a = 0, b = 0;\r\n    \r\n    std::cin >> a >> b;\r\n    std::cout << a + b << std::endl;\r\n    \r\n    return 0;\r\n}'),
(1000, 1, '2020-04-10 00:00:00', '2020-04-10 00:00:05', 30, 300, 'AC', 100, 'Wrong Answer.\r\n', '#include <iostream>\r\n\r\nint main() {\r\n    int a = 0, b = 0;\r\n    \r\n    std::cin >> a >> b;\r\n    std::cout << a + b << std::endl;\r\n    \r\n    return 0;\r\n}');

DROP TABLE IF EXISTS `language_information`;
CREATE TABLE `language_information` (
    `language_name` varchar(8) COLLATE utf8mb4_unicode_ci NOT NULL,
    `language_description` text COLLATE utf8mb4_unicode_ci NOT NULL,
    `compile_command` text COLLATE utf8mb4_unicode_ci NOT NULL
);
INSERT INTO `language_information` (`language_name`, `language_description`, `compile_command`) VALUES
('C++', 'G++ 5.4', '/usr/bin/g++ -DONLINE_JUDGE -O2 -w -fmax-errors=3 -std=c++14 {src_path} -lm -o {exe_path}');

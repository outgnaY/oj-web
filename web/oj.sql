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
('测试31', '测试内容31'),
('测试32', '测试内容32');

# 题目数据表
DROP TABLE IF EXISTS `oj_problems`;
CREATE TABLE `oj_problems` (
    `problem_id` bigint(20) NOT NULL,
    `problem_name` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL,
    `problem_time_limit` int(8) NOT NULL,
    `problem_memory_limit` int(8) NOT NULL,
    `problem_description` text COLLATE utf8mb4_unicode_ci NOT NULL,
    `problem_input_format` text COLLATE utf8mb4_unicode_ci NOT NULL,
    `problem_output_format` text COLLATE utf8mb4_unicode_ci NOT NULL,
    `problem_sample_input` text COLLATE utf8mb4_unicode_ci NOT NULL,
    `problem_sample_output` text COLLATE utf8mb4_unicode_ci NOT NULL,
    `problem_hint` text COLLATE utf8mb4_unicode_ci,
    PRIMARY KEY(`problem_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
# 测试数据
INSERT INTO `oj_problems` (`problem_id`, `problem_name`, `problem_time_limit`, `problem_memory_limit`, `problem_description`, `problem_input_format`, `problem_output_format`, `problem_sample_input`, `problem_sample_output`, `problem_hint`) VALUES
(1000, 'A+B Problem', 1000, 65536, '输入两个自然数, 输出他们的和', '两个自然数x和y (0<=x, y<=32767).', '一个数, 即x和y的和.', '123 500', '623', '## C++ Code\r\n\r\n    #include <iostream>\r\n\r\n    int main() {\r\n        int a = 0, b = 0;\r\n        std::cin >> a >> b;\r\n        std::cout << a + b << std::endl;\r\n        return 0;\r\n    }\r\n\r\n## Free Pascal Code\r\n\r\n    program Plus;\r\n    var a, b:longint;\r\n    begin\r\n        readln(a, b);\r\n        writeln(a + b);\r\n    end.\r\n\r\n## Java Code\r\n\r\n    import java.util.Scanner;\r\n\r\n    public class Main {\r\n        public static void main(String[] args) {\r\n            Scanner in = new Scanner(System.in);\r\n            int a = in.nextInt();\r\n            int b = in.nextInt();\r\n            System.out.println(a + b);\r\n        }\r\n    }\r\n');

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

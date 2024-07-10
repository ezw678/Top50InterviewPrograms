from hypothesis import given, strategies as st, settings
from hypothesis.strategies import recursive, integers, builds, none
import math
from .tree_node import TreeNode, root
from .top50 import *


@given(st.integers(min_value=2, max_value=500))
def test_int_palindrome(n: int):
    assert int_palindrome_1(n) == int_palindrome_2(n)


def test_armstrong_number():
    assert armstrong_number(153)
    assert armstrong_number(371)
    assert not armstrong_number(176)
    assert armstrong_number(370)
    assert not armstrong_number(111)
    assert armstrong_number(407)


@given(st.lists(st.integers(), min_size=0, max_size=50))
def test_remove_dups_in_list(nums: list[int]):
    assert (
        sorted(remove_dups_in_list_1(nums))
        == sorted(remove_dups_in_list_2(nums))
        == sorted(remove_dups_in_list_3(nums))
    )


@given(st.lists(st.integers(), min_size=0, max_size=50))
def test_del_dups_in_list(nums: list[int]):
    assert sorted(del_dups_in_list_1(nums)) == sorted(del_dups_in_list_2(nums))


@given(st.text())
def test_find_dup_chars_in_str(s: str):
    assert find_dup_chars_in_str_1(s) == find_dup_chars_in_str_2(s)


@given(st.floats(min_value=0.00001, max_value=200.0))
def test_find_sqrt(n: int):
    assert abs(find_sqrt(n) - math.sqrt(n)) <= 0.00000001


def test_binary_search():
    arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
    target = 12
    assert binary_search(arr, target) == -1
    target = 5
    assert binary_search(arr, target) == 4
    target = 8
    assert binary_search(arr, target) == 7


def test_reverse_number():
    assert reverse_number_1(153) == 351
    assert reverse_number_1(218) == 812
    assert reverse_number_1(982) == 289
    assert reverse_number_1(120) == 21
    assert reverse_number_1(169) == 961


@given(st.integers())
def test_reverse_number(n: int):
    assert reverse_number_1(n) == reverse_number_2(n)


def test_find_first_non_repeat_char_1():
    assert find_first_non_repeat_char_1("hello") == "h"
    assert find_first_non_repeat_char_1("programming") == "p"
    assert find_first_non_repeat_char_1("preparing") == "e"


def test_find_first_non_repeat_char_2():
    assert find_first_non_repeat_char_2("hello") == "h"
    assert find_first_non_repeat_char_2("programming") == "p"
    assert find_first_non_repeat_char_2("preparing") == "e"


@given(st.text())
def test_find_first_non_repeat_char(s: str):
    assert find_first_non_repeat_char_1(s) == find_first_non_repeat_char_2(s)


def tree_strategy(max_depth=5):
    base = builds(TreeNode, integers(min_value=0, max_value=100))
    return recursive(
        base,
        lambda children: builds(
            TreeNode,
            integers(min_value=0, max_value=100),
            left=none() | children,
            right=none() | children,
        ),
        max_leaves=2**max_depth,
    )


# Test function using Hypothesis with settings to limit execution time and iterations
@settings(max_examples=100, deadline=1000)
@given(tree=tree_strategy())
def test_pre_order_traversal(tree):
    actual = pre_order_traversal(tree)
    expected = []
    pre_order_traversal_recursive(tree, expected)
    assert actual == expected, f"Actual: {actual}, Expected: {expected}"


@given(st.lists(st.integers(), min_size=10, max_size=50))
def test_sort_algorithms(nums: list[int]):
    c1 = nums[:]
    insertion_sort(c1)
    c2 = nums[:]
    bubble_sort(c2)
    assert c1 == c2 == sorted(nums)


@given(st.lists(st.integers(), min_size=10, max_size=50))
def test_quicksort_1(nums: list[int]):
    nums_copy = nums[:]
    quicksort_1(nums_copy, 0, len(nums) - 1)
    assert nums_copy == sorted(nums)


@given(st.lists(st.integers(), min_size=10, max_size=50))
def test_quicksort_2(nums: list[int]):
    nums_copy = nums[:]
    assert quicksort_2(nums_copy) == sorted(nums)


@given(st.lists(st.integers()))
def test_quicksort_preserves_length(nums):
    nums_copy = nums.copy()
    sorted_lst = quicksort_2(nums)
    assert len(nums_copy) == len(sorted_lst), "Quicksort does not preserve list length"


@given(st.lists(st.integers(), min_size=10, max_size=50))
def test_merge_sort(nums: list[int]):
    assert merge_sort(nums) == sorted(nums)


def test_pre_order_traversal():
    lst = []
    pre_order_traversal_recursive(root, lst)
    assert pre_order_traversal(root) == lst


def test_in_order_traversal():
    lst = []
    in_order_traversal_recursive(root, lst)
    assert in_order_traversal(root) == lst


def test_post_order_traversal():
    lst = []
    post_order_traversal_recursive(root, lst)
    assert post_order_traversal(root) == lst


@given(st.text(min_size=2, max_size=8))
def test_str_permutation(word):
    lst0 = []
    str_permutation_1(word, 0, len(word) - 1, lst0)
    lst1 = []
    str_permutation_2(word, "", lst1)
    assert sorted(lst0) == sorted(lst1)


def test_check_str_rotation():
    assert check_str_rotation("abcd", "cdab") == True
    assert check_str_rotation("abcd", "acbd") == False
    assert check_str_rotation("AACD", "ACDA") == True
    assert check_str_rotation("waterbottle", "erbottlewat") == True
    assert check_str_rotation("hello", "lohel") == True
    assert check_str_rotation("python", "thonpy") == True
    assert check_str_rotation("abc", "cba") == False
